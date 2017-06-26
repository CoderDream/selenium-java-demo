package com.coderdream.db.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.db.bean.TableCompareBean;

public class MssqlServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(MssqlServiceTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCompareTableName() {
		String databaseName1 = "BJC_Finance";
		String databaseName2 = "BJC_Finance_Test";
		Map<String, Integer> compareMap = MssqlService
				.compareTableName(databaseName1, databaseName2);
		for (String tableName : compareMap.keySet()) {
			Integer compareResult = compareMap.get(tableName);
			logger.debug(tableName + "\t" + compareResult);
			System.out.println(tableName + "\t" + compareResult);
		}
	}

	@Test
	public void testCompareTableConstruct() {
		String databaseName1 = "BJC_Finance";
		String databaseName2 = "BJC_Finance_Test";
		String tableName = "T_Users";
		List<TableCompareBean> tableCompareBeanList = MssqlService
				.compareTableConstruct(databaseName1, databaseName2, tableName);
		for (TableCompareBean tableCompareBean : tableCompareBeanList) {
			logger.debug("tableCompareBean\t" + tableCompareBean);
			System.out.println("tableCompareBean\t" + tableCompareBean);
		}
	}

	@Test
	public void testCompareTableConstructTotal() {
		String databaseName1 = "BJC_Finance";
		String databaseName2 = "BJC_Finance_Test";
		List<TableCompareBean> tableCompareBeanList = MssqlService
				.compareTableConstructTotal(databaseName1, databaseName2);
		for (TableCompareBean tableCompareBean : tableCompareBeanList) {
			logger.debug("tableCompareBean\t" + tableCompareBean);
			System.out.println("tableCompareBean\t" + tableCompareBean);
		}
	}

	@Test
	public void testCompareTableConstructDiff() {
		String databaseName1 = "BJC_Finance";
		String databaseName2 = "BJC_Finance_Test";
		Map<String, List<TableCompareBean>> totalTableCompareBeanListMap = MssqlService
				.compareTableConstructDiff(databaseName1, databaseName2);
		for (String tableName : totalTableCompareBeanListMap.keySet()) {
			List<TableCompareBean> tableCompareBeanList = totalTableCompareBeanListMap
					.get(tableName);
			System.out.println("###tableName\t" + tableName);
			for (TableCompareBean tableCompareBean : tableCompareBeanList) {
				System.out.println(tableCompareBean);
			}
		}
	}

}
