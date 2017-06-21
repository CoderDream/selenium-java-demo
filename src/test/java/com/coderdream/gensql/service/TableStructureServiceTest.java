package com.coderdream.gensql.service;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.gensql.bean.TableStructure;
import com.coderdream.util.Common;

public class TableStructureServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(TableStructureServiceTest.class);

	@Test
	public void testGetTableStructureList() {
		String path = "TableStructure.xlsx";
		logger.debug(Common.PROCESSING + path);
		TableStructureService tableStructureService = new TableStructureService();
		String fileFolder = getClass().getResource("../../../../").getFile().toString();
		System.out.println(fileFolder);
		List<TableStructure> list = tableStructureService.getTableStructureList(fileFolder + path);
		for (TableStructure tableStructure : list) {
			System.out.println(tableStructure.getTableName() + "\t" + tableStructure.getColumnName() + "\t"
					+ tableStructure.getType() + "\t");
		}
	}

	@Test
	public void testGetTableStructure_01() {
		String path = "TableStructure.xlsx";
		logger.debug(Common.PROCESSING + path);
		TableStructureService tableStructureService = new TableStructureService();
		String tableNameParam = "T_Users";
		List<TableStructure> list = tableStructureService.getTableStructure(path, tableNameParam);
		for (TableStructure tableStructure : list) {
			System.out.println(tableStructure.getTableName() + "\t" + tableStructure.getColumnName() + "\t"
					+ tableStructure.getType() + "\t" + tableStructure.getNullFlag() + "\t");
		}
	}

	@Test
	public void testGetTableStructure_02() {
		String path = "TableStructure.xlsx";
		logger.debug(Common.PROCESSING + path);
		TableStructureService tableStructureService = new TableStructureService();
		String tableNameParam = "ISBG_HumanMap";
		List<TableStructure> list = tableStructureService.getTableStructure(path, tableNameParam);
		for (TableStructure tableStructure : list) {
			System.out.println(tableStructure.getTableName() + "\t" + tableStructure.getColumnName() + "\t"
					+ tableStructure.getType() + "\t" + tableStructure.getNullFlag() + "\t");
		}
	}

	@Test
	public void testGetColumnType_02() {
		TableStructureService tableStructureService = new TableStructureService();
		String tableNameParam = "ISBG_HumanMap";
		String columnNameParam = "OutPro_Date";
		String type = tableStructureService.getColumnType(tableNameParam, columnNameParam);
		System.out.println("type:" + type);
	}

	@Test
	public void testGetNotNullColumnList_01() {
		String path = "TableStructure.xlsx";
		logger.debug(Common.PROCESSING + path);
		TableStructureService tableStructureService = new TableStructureService();
		String fileFolder = getClass().getResource("../../../../").getFile().toString();
		System.out.println(fileFolder);
		String tableNameParam = "T_Users";
		List<TableStructure> list = tableStructureService.getNotNullColumnList(fileFolder + path, tableNameParam);
		for (TableStructure tableStructure : list) {
			logger.debug(tableStructure.getTableName() + "\t" + tableStructure.getColumnName() + "\t"
					+ tableStructure.getType() + "\t" + tableStructure.getNullFlag() + "\t");
		}
	}

	@Test
	public void testGetNotNullColumnList_02() {
		String path = "TableStructure.xlsx";
		logger.debug(Common.PROCESSING + path);
		TableStructureService tableStructureService = new TableStructureService();
		String fileFolder = getClass().getResource("../../../../").getFile().toString();
		System.out.println(fileFolder);
		String tableNameParam = "ISBG_HumanMap";
		List<TableStructure> list = tableStructureService.getNotNullColumnList(fileFolder + path, tableNameParam);
		for (TableStructure tableStructure : list) {
			logger.debug(tableStructure.getTableName() + "\t" + tableStructure.getColumnName() + "\t"
					+ tableStructure.getType() + "\t" + tableStructure.getNullFlag() + "\t");
		}
	}

}
