package com.coderdream.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.coderdream.db.bean.TableCompareBean;
import com.coderdream.db.mssql.MssqlUtil;

public class MssqlService {

	public static Map<String, Integer> compareTableName(String databaseName1,
			String databaseName2) {
		String sql = "SELECT * FROM SYS.TABLES ORDER BY NAME;";
		String columns = "NAME";
		List<String[]> rusultList = MssqlUtil.executeQuery(databaseName1, sql,
				columns);
		Set<String> setTotal = new TreeSet<String>();
		Set<String> setA = new TreeSet<String>();
		for (String[] string : rusultList) {
			setA.add(string[0]);
			setTotal.add(string[0]);
		}

		List<String[]> rusultList2 = MssqlUtil.executeQuery(databaseName2, sql,
				columns);
		Set<String> setB = new TreeSet<String>();
		for (String[] string : rusultList2) {
			setB.add(string[0]);
			setTotal.add(string[0]);
		}

		Map<String, Integer> compareMap = new TreeMap<String, Integer>();
		for (String string : setTotal) {
			boolean a = setA.contains(string);
			boolean b = setB.contains(string);
			if (a && b) {
				compareMap.put(string, 0);
			} else if (a) {
				compareMap.put(string, -1);
			} else if (b) {
				compareMap.put(string, 1);
			} else {
				compareMap.put(string, -100);
			}
		}

		return compareMap;
	}

	public static Set<String> getTotalTableName(String databaseName1,
			String databaseName2) {
		Set<String> setTotal = new TreeSet<String>();
		String sql = "SELECT * FROM SYS.TABLES ORDER BY NAME;";
		String columns = "NAME";
		List<String[]> rusultList = MssqlUtil.executeQuery(databaseName1, sql,
				columns);

		for (String[] string : rusultList) {
			setTotal.add(string[0]);
		}

		List<String[]> rusultList2 = MssqlUtil.executeQuery(databaseName2, sql,
				columns);
		for (String[] string : rusultList2) {
			setTotal.add(string[0]);
		}

		return setTotal;
	}

	public static List<TableCompareBean> compareTableConstruct(
			String databaseName1, String databaseName2, String tableName) {
		List<TableCompareBean> tableCompareBeanList = new ArrayList<TableCompareBean>();
		StringBuffer sql = new StringBuffer("SELECT SYSCOLUMNS.NAME NAME,");
		sql.append("SYSTYPES.NAME TYPE,");
		sql.append("SYSCOLUMNS.ISNULLABLE ISNULLABLE,");
		sql.append("SYSCOLUMNS.LENGTH LENGTH");
		sql.append(" FROM SYSCOLUMNS,");
		sql.append("SYSTYPES ");
		sql.append("WHERE SYSCOLUMNS.XUSERTYPE = SYSTYPES.XUSERTYPE ");
		sql.append("AND SYSCOLUMNS.ID = OBJECT_ID('" + tableName + "');");
		String columns = "NAME,TYPE,ISNULLABLE,LENGTH";
		List<String[]> rusultList = MssqlUtil.executeQuery(databaseName1,
				sql.toString(), columns);
		Map<String, String> mapTotal = new TreeMap<String, String>();
		Map<String, String> mapA = new TreeMap<String, String>();
		for (String[] string : rusultList) {
			String others = string[1] + "_" + string[2] + "_" + string[3];
			mapTotal.put(string[0], others);
			mapA.put(string[0], others);
		}

		List<String[]> rusultList2 = MssqlUtil.executeQuery(databaseName2,
				sql.toString(), columns);
		Map<String, String> mapB = new TreeMap<String, String>();
		for (String[] string : rusultList2) {
			String others = string[1] + "_" + string[2] + "_" + string[3];
			mapTotal.put(string[0], others);
			mapB.put(string[0], others);
		}

		TableCompareBean tableCompareBean = null;
		for (String columnName : mapTotal.keySet()) {
			tableCompareBean = new TableCompareBean();
			tableCompareBean.setTableName(tableName);
			String others = mapTotal.get(columnName);

			boolean a = mapA.containsKey(columnName);
			if (a) {
				tableCompareBean.setLeftColumnName(columnName);
			}
			boolean b = mapB.containsKey(columnName);
			if (b) {
				tableCompareBean.setRightColumnName(columnName);
			}

			String leftOthers = mapA.get(columnName);
			tableCompareBean.setLeftOthers(leftOthers);
			String rigthOthers = mapB.get(columnName);
			tableCompareBean.setRigthOthers(rigthOthers);

			if (a & b & others.equals(leftOthers)
					& others.equals(rigthOthers)) {
				tableCompareBean.setCompareResult(true);
			} else {
				tableCompareBean.setCompareResult(false);
			}

			tableCompareBeanList.add(tableCompareBean);
		}

		return tableCompareBeanList;
	}

	public static Boolean compareTableConstructResult(
			List<TableCompareBean> tableCompareBeanList) {
		Boolean result = true;
		for (TableCompareBean tableCompareBean : tableCompareBeanList) {
			Boolean compareResult = tableCompareBean.getCompareResult();
			result = result && compareResult;
		}

		return result;
	}

	public static List<TableCompareBean> compareTableConstructTotal(
			String databaseName1, String databaseName2) {
		List<TableCompareBean> totalTableCompareBeanList = new ArrayList<TableCompareBean>();

		Set<String> setTotal = getTotalTableName(databaseName1, databaseName2);
		for (String tableName : setTotal) {
			List<TableCompareBean> tableCompareBeanList = MssqlService
					.compareTableConstruct(databaseName1, databaseName2,
							tableName);
			for (TableCompareBean tableCompareBean : tableCompareBeanList) {
				tableCompareBean.setTableName(tableName);
				totalTableCompareBeanList.add(tableCompareBean);
			}
		}

		return totalTableCompareBeanList;
	}

	public static Map<String, List<TableCompareBean>> compareTableConstructDiff(
			String databaseName1, String databaseName2) {
		Map<String, List<TableCompareBean>> totalTableCompareBeanListMap = new TreeMap<String, List<TableCompareBean>>();

		Set<String> setTotal = getTotalTableName(databaseName1, databaseName2);
		for (String tableName : setTotal) {
			List<TableCompareBean> tableCompareBeanList = MssqlService
					.compareTableConstruct(databaseName1, databaseName2,
							tableName);
			if (!compareTableConstructResult(tableCompareBeanList)) {
				totalTableCompareBeanListMap.put(tableName,
						tableCompareBeanList);
			}
		}

		return totalTableCompareBeanListMap;
	}
}
