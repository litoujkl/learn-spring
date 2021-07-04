package com.shuangji.demo.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestHikacriCP {

	private static DataSource dataSource = null;

	static {
		try {
			HikariConfig config = new HikariConfig("/hikari.properties");
			dataSource = new HikariDataSource(config);
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
