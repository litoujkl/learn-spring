package com.shuangji.demo.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestDruid {

	private static DruidDataSource dataSource = null;

	static {
		try {
			InputStream inputStream = TestDruid.class.getClassLoader().getResourceAsStream("druid.properties");
			Properties p = new Properties();
			p.load(inputStream);
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from t1");
			int cols = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					System.out.print("\t" + rs.getString(i));
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (Exception e) {
				// Ignore
			}
			try {
				if (stmt != null) stmt.close();
			} catch (Exception e) {
				// Ignore
			}
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				// Ignore
			}
		}
	}
}
