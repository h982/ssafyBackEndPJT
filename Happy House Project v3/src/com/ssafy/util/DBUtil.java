package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String ID = "ssafy";
	private static final String PASSWORD = "ssafy";

	public DBUtil() {
		try {
			Class.forName(DRIVER);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static Connection getConnect() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	public static void close(AutoCloseable... closeables) {
		try {
			for(AutoCloseable ac : closeables) {
				if(ac != null)
					ac.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
