package com.coderdream.db.mssql;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MssqlUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecuteQuery_01() {
		String projectName = "P06211624";
		String sql = "Select * from ISBG_Project ip where ip.projectName='"
				+ projectName + "';";
		String columns = "ID,ProjectName,IsFinish";
		List<String[]> rusultList = MssqlUtil.executeQuery(sql, columns);
		for (String[] string : rusultList) {
			System.out.println(string + "\t");
		}
	}

	@Test
	public void testExecuteQuery_02() {
		String sql = "Select * from ISBG_Project";
		String columns = "ID,ProjectName,IsFinish";
		List<String[]> rusultList = MssqlUtil.executeQuery(sql, columns);
		for (String[] string : rusultList) {
			System.out.println(string + "\t");
		}
	}

	@Test
	public void testExecuteQuery_03() {
		String sql = "SELECT * FROM SYS.TABLES ORDER BY NAME;";
		MssqlUtil.executeQuery(sql);
	}

	@Test
	public void testExecuteQuery_04() {
		String sql = "SELECT * FROM SYS.TABLES ORDER BY NAME;";
		String columns = "NAME";
		List<String[]> rusultList = MssqlUtil.executeQuery(sql, columns);
		System.out.println("rusultList size: " + rusultList.size());
		for (String[] string : rusultList) {
			System.out.println(string + "\t");
		}
	}

	@Test
	public void testExecuteQuery_05() {
		String databaseName2 = "BJC_Finance_Test";
		String tableName = "T_Users";
		StringBuffer sql = new StringBuffer("SELECT SYSCOLUMNS.NAME NAME,");
		sql.append("SYSTYPES.NAME TYPE,");
		sql.append("SYSCOLUMNS.ISNULLABLE ISNULLABLE,");
		sql.append("SYSCOLUMNS.LENGTH LENGTH");
		sql.append(" FROM SYSCOLUMNS,");
		sql.append("SYSTYPES ");
		sql.append("WHERE SYSCOLUMNS.XUSERTYPE = SYSTYPES.XUSERTYPE ");
		sql.append("AND SYSCOLUMNS.ID = OBJECT_ID('" + tableName + "');");
		String columns = "NAME,TYPE,ISNULLABLE,LENGTH";
		List<String[]> rusultList = MssqlUtil.executeQuery(databaseName2,
				sql.toString(), columns);
		System.out.println("rusultList size: " + rusultList.size());
		for (String[] string : rusultList) {
			for (int i = 0; i < string.length; i++) {
				String string2 = string[i];
				System.out.print(string2 + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void testExecuteUpdate_01() {
		String projectName = "P06211624";
		String sql = "Update ISBG_Project set IsFinish=1 where projectName='"
				+ projectName + "';";
		int result = MssqlUtil.executeUpdate(sql);
		System.out.println(result + "\t");
	}

	@Test
	public void testExecuteUpdate_02() {
		String projectName = "P06211624";
		String sql = "Update ISBG_Project set IsFinish=0 where projectName='"
				+ projectName + "';";
		int result = MssqlUtil.executeUpdate(sql);
		System.out.println(result + "\t");
	}

	@Test
	public void testExecuteUpdate_03() {
		StringBuffer sql = new StringBuffer("INSERT INTO ISBG_Project_Finish(");
		sql.append("ID,");
		sql.append("StartTime,");
		sql.append("EndTime,");
		sql.append("ProjectId,");
		sql.append("Statues,");
		sql.append("IsSubmit,");
		sql.append("CreateWorkId,");
		sql.append("ProjectStartDateTime,");
		sql.append("ProjectEndDateTime");
		sql.append(") VALUES (");
		sql.append("newId(),");
		sql.append("N'2017-06-22',");
		sql.append("N'2017-06-22',");
		sql.append("'4A6251B4-1E00-403D-A3F8-8453EBA1C3C1',");
		sql.append("2,");
		sql.append("1,");
		sql.append("'B-26050',");
		sql.append("N'2017-06-22',");
		sql.append("N'2017-06-22'");
		sql.append(");");
		System.out.println(sql.toString());
		int result = MssqlUtil.executeUpdate(sql.toString());

		System.out.println(result + "\t");
	}

	/**
	 * SELECT TOP 1000 [ID] ,[ProjectID] ,[WorkID] ,[DispatchMonth]
	 * ,[ConfrimTime] ,[BSMState]
	 */
	@Test
	public void testExecuteUpdate_04() {
		String projectID = "4A6251B4-1E00-403D-A3F8-8453EBA1C3C1";
		String workID = "B-024";
		String sql = "Update PDRC_BSM_Dispatch set ConfrimTime='2017-06-22', BSMState=3 where projectID='"
				+ projectID + "' and WorkID='" + workID + "';";
		System.out.println(sql);
		int result = MssqlUtil.executeUpdate(sql);

		System.out.println(result + "\t");
	}
}
