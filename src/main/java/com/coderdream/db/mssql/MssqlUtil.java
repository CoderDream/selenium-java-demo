package com.coderdream.db.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jtds.jdbc.Driver;

public class MssqlUtil {

	public static List<String[]> executeQuery(String sql) {
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<String[]> result = new ArrayList<String[]>();

			// 获取列名
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				// resultSet数据下标从1开始
				String columnName = metaData.getColumnName(i + 1);
				int type = metaData.getColumnType(i + 1);
				if (Types.INTEGER == type) {
					// int
				} else if (Types.VARCHAR == type) {
					// String
				}
				System.out.print(columnName + "\t" + type + "\t");
			}
			System.out.println();
			String[] strArray = null;
			while (rs.next()) {

				// //String[] columnList = columns.split(",");
				// strArray = set.siz
				// for (String str : columnList) {
				// result.add(set.getString(str));
				// }
			}
			rs.close();
			st.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * 
	 * @param sql
	 * @param columns
	 * @return
	 */
	public static List<String[]> executeQuery(String sql, String columns) {
		Connection conn = getConnection();
		return executeQuery(sql, columns, conn);
	}

	public static List<String[]> executeQuery(String databaseName, String sql,
					String columns) {
		Connection conn = getConnection(databaseName);
		return executeQuery(sql, columns, conn);
	}

	// private static List<String> executeQuery(String sql, String columns,
	// Connection conn) {
	// try {
	// Statement st = conn.createStatement();
	// ResultSet rs = st.executeQuery(sql);
	// List<String> result = new ArrayList<String>();
	//
	// while (rs.next()) {
	// // ColInfo[] colInfoArray = jrs.getColumns();
	// String[] columnList = columns.split(",");
	// for (String str : columnList) {
	// result.add(rs.getString(str));
	// }
	// }
	// rs.close();
	// st.close();
	// conn.close();
	// return result;
	// } catch (SQLException e) {
	// throw new IllegalArgumentException(e);
	// }
	// }

	private static List<String[]> executeQuery(String sql, String columns,
					Connection conn) {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<String[]> result = new ArrayList<String[]>();

			while (rs.next()) {
				// ColInfo[] colInfoArray = jrs.getColumns();
				String[] columnList = columns.split(",");
				int length = columnList.length;
				String[] resultList = new String[length];
				for (int i = 0; i < length; i++) {
					resultList[i] = rs.getString(columnList[i]);
				}
				result.add(resultList);
			}
			rs.close();
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

	public static int executeUpdate(Connection conn, String sql) {
		try {
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
			// Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// String url =
			// "jdbc:jtds:sqlserver://10.100.254.96:1433;DatabaseName=BJC_Finance_Test";
			String url = "jdbc:sqlserver://10.100.254.96:1433;DatabaseName=BJC_Finance_Test";
			// String connectionUrl =
			// "jdbc:sqlserver://127.0.0.1:1433;databaseName=NewDB;user=sa;password=lty@123;";
			String username = "sa";
			String password = "sa3223624";
			Connection conn = DriverManager.getConnection(url, username,
							password);
			return conn;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Connection getConnection(String databaseName) {
		try {
			// Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Driver d = null;
			// String url =
			// "jdbc:jtds:sqlserver://10.100.254.96:1433;DatabaseName=BJC_Finance_Test";
			String url = "jdbc:sqlserver://10.100.254.96:1433;DatabaseName="
							+ databaseName + "";
			// String connectionUrl =
			// "jdbc:sqlserver://127.0.0.1:1433;databaseName=NewDB;user=sa;password=lty@123;";
			String username = "sa";
			String password = "sa3223624";
			Connection conn = DriverManager.getConnection(url, username,
							password);
			return conn;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Connection getConnectionByConnectionUrl(
					String connectionUrl) {
		try {
			// Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// Driver d = null;
			// String url =
			// "jdbc:jtds:sqlserver://10.100.254.96:1433;DatabaseName=BJC_Finance_Test";
			// String url = "jdbc:sqlserver://10.100.254.96:1433;DatabaseName="
			// + databaseName + "";
			// String connectionUrl =
			// "jdbc:sqlserver://127.0.0.1:1433;databaseName=NewDB;user=sa;password=lty@123;";
			String username = "sa";
			String password = "sa3223624";
			Connection conn = DriverManager.getConnection(connectionUrl,
							username, password);
			return conn;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static void main(String[] args) {
		String sql = "SELECT * FROM PDRC_TM";
		String columns = "ID,WorkID,RMWorkID";
		List<String[]> rusultList = executeQuery(sql, columns);
		for (String[] string : rusultList) {
			for (int i = 0; i < string.length; i++) {
				String string2 = string[i];
				System.out.print(string2 + "\t");
			}
			System.out.println();
		}
	}
}
