package com.coderdream.sadp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.coderdream.db.mssql.MssqlUtil;
import com.coderdream.util.ExcelUtil;

public class InitDataUtil {

	public static Map<String, Set<String>> getInitDateMap(String path,
					String sheetName) throws IOException {
		Map<String, Set<String>> map = new LinkedHashMap<String, Set<String>>();
		List<String[]> arrayList = ExcelUtil.readAllData(path, sheetName);
		for (String[] strings : arrayList) {
			int length = strings.length;
			if (0 < length) {
				String roleName = strings[0];
				for (int i = 1; i < strings.length; i++) {
					String string = strings[i];

					System.out.println(string);
					Set<String> workIdSet = map.get(roleName);
					if (null == workIdSet) {
						workIdSet = new HashSet<String>();
					}
					workIdSet.add(string);
					map.put(roleName, workIdSet);
				}
			}
		}
		return map;
	}

	public static void updateDB(Map<String, Set<String>> map)
					throws SQLException {

		String connectionUrl = "jdbc:jtds:sqlserver://10.100.254.96:1433/BJC_COMMON_RBAC_DEV";
		Connection conn = MssqlUtil.getConnectionByConnectionUrl(connectionUrl);
		// 先查看user如果有，取ID，如果没有新增
		String getMaxUserIdStr = "SELECT max(id) from [user];";
		String getMaxUserRoleIdStr = "SELECT max(id) from [user_role];";
		Integer maxUserId = 0;
		Integer maxUserRoleId = 0;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(getMaxUserIdStr);
		while (rs.next()) {
			maxUserId = rs.getInt(1);
			System.out.println("maxUserId:\t" + maxUserId);
		}
		rs = st.executeQuery(getMaxUserRoleIdStr);
		while (rs.next()) {
			maxUserRoleId = rs.getInt(1);
			System.out.println("maxUserRole:\t" + maxUserRoleId);
		}

		String getUser = "SELECT * from [user] where work_id = '";

		String inserIntoUser = "INSERT INTO [user]([id],[work_id]) VALUES ( ";
		// <id, bigint,>
		// ,<work_id, nvarchar(255),>)";
		String userWorkId;
		Integer userId = 0;
		Integer roleId = 0;

		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
			String roleName = entry.getKey();
			String getRoleIdString = "select id from role r where role_name = ? ";
			PreparedStatement ps0 = conn.prepareStatement(getRoleIdString);
			ps0.setString(1, roleName); // 对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
			ResultSet rs0 = ps0.executeQuery();
			while (rs0.next()) {
				roleId = rs0.getInt(1);
				System.out.println("roleId2:\t" + roleId);
			}

			Set<String> workIdSet = map.get(roleName);

			for (String workId : workIdSet) {
				System.out.println(workId + "\t" + roleName);
				ResultSet rs2 = st.executeQuery(getUser + workId + "'");
				if (rs2.next()) {
					userId = rs2.getInt(1);
					userWorkId = rs2.getString(3);
					System.out.println("userId:\t" + userWorkId);
					while (rs2.next()) {
						userWorkId = rs2.getString(3);
						System.out.println("userId:\t" + userWorkId);
					}
				} else {
					maxUserId++;
					String inserIntoUserSql = inserIntoUser + maxUserId + ", '"
									+ workId + "')";
					System.out.println(
									"inserIntoUserSql:\t" + inserIntoUserSql);
					int rs3 = st.executeUpdate(inserIntoUserSql);
					System.out.println("result:\t" + rs3);
				}

				// TODO
				// String getUserRoleSql = "select * from [user] u, user_role
				// ur, role r where u.id=ur.user_id and ur.role_id = r.id and
				// r.role_name = 'Staff' and u.work_id='B-12007'";
				String getUserRoleSql = "select role_id from [user] u, user_role ur, role r where u.id=ur.user_id and ur.role_id = r.id and r.role_name = ? and u.work_id=?";
				PreparedStatement ps = conn.prepareStatement(getUserRoleSql);
				ps.setString(1, roleName); // 对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
				ps.setString(2, workId);
				ResultSet rs4 = ps.executeQuery();
				if (rs4.next()) {
					roleId = rs4.getInt(1);
					System.out.println("roleId:\t" + roleId);
				} else {
					maxUserRoleId++;
//					String inserIntoUserRole = "INSERT INTO [user_role]([id],[user_id],[role_id]) VALUES (?,?,?)";
//					PreparedStatement ps2 = conn
//									.prepareStatement(inserIntoUserRole);
//					ps2.setInt(1, maxUserRoleId);
//					ps2.setInt(2, userId);
//					ps2.setInt(3, roleId);
//					int rs5 = ps2.executeUpdate(inserIntoUserRole);
//					System.out.println("rs5:\t" + rs5);
					String inserIntoUserRole = "INSERT INTO [user_role]([id],[user_id],[role_id]) VALUES (";
					String inserIntoUserRoleSql = inserIntoUserRole + maxUserRoleId + ", " + userId + "," + roleId + ")";
					System.out.println(
									"inserIntoUserRoleSql:\t" + inserIntoUserRoleSql);
					int rs5 = st.executeUpdate(inserIntoUserRoleSql);
					System.out.println("rs5 result:\t" + rs5);
				}
			}
		}

		rs.close();
		st.close();
		conn.close();

	}
}
