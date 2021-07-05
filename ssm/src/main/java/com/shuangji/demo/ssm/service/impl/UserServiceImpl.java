package com.shuangji.demo.ssm.service.impl;

import com.shuangji.demo.ssm.dao.IUserDao;
import com.shuangji.demo.ssm.pojo.User;
import com.shuangji.demo.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

}
