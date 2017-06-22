package com.coderdream.db.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MssqlUtil {
	public static List<String> executeQuery(String sql, String columns) {
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			ResultSet set = st.executeQuery(sql);
			List<String> result = new ArrayList<String>();
			while (set.next()) {
				String[] columnList = columns.split(",");
				for (String str : columnList) {
					result.add(set.getString(str));
				}
			}
			set.close();
			st.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static int executeUpdate(String sql) {
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			int result = st.executeUpdate(sql);
			st.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Connection getConnection() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String url = "jdbc:jtds:sqlserver://10.100.254.96:1433;DatabaseName=BJC_Finance_Test";
			String username = "sa";
			String password = "sa3223624";
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static void main(String[] args) {
		String sql = "SELECT * FROM PDRC_TM";
		String columns = "ID,WorkID,RMWorkID";
		List<String> rusultList = executeQuery(sql, columns);
		for (String string : rusultList) {
			System.out.println(string + "\t");
		}
	}
}
