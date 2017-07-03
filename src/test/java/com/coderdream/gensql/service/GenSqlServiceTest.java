package com.coderdream.gensql.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.util.Common;
import com.coderdream.util.Constants;

public class GenSqlServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(GenSqlServiceTest.class);

	private String fileFolder;

	@Before
	public void setUp() throws Exception {
		fileFolder = getClass().getResource("../../../../").getFile().toString();
	}

	@Test
	public void testGenSqlScriptList() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = Constants.DATA_FILE_NAME;
		String sheetName = "T_Users";
		String path = fileFolder + fileName;
		String sqlFileName = sheetName + ".sql";
		String sqlFilePath = fileFolder + sqlFileName;
		// 是否自动生成ID
		Boolean idFlag = true;
		String charsetName = "GBK";
		GenSqlService.genSqlScriptFile(path, sheetName, idFlag, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptList_02() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = Constants.DATA_FILE_NAME;
		String sheetName = "ISBG_Project";
		String path = fileFolder + fileName;
		String sqlFileName = sheetName + ".sql";
		String sqlFilePath = fileFolder + sqlFileName;
		// 是否自动生成ID
		Boolean idFlag = false;
		String charsetName = "GBK";
		GenSqlService.genSqlScriptFile(path, sheetName, idFlag, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptList_03() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = Constants.DATA_FILE_NAME;
		String sheetName = "ISBG_HumanMap";
		String path = fileFolder + fileName;
		String sqlFileName = sheetName + ".sql";
		String sqlFilePath = fileFolder + sqlFileName;
		// 是否自动生成ID
		Boolean idFlag = false;
		String charsetName = "GBK";
		GenSqlService.genSqlScriptFile(path, sheetName, idFlag, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptList_04() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = "Data_20170531.xlsx";
		String sheetName = "PDRC_StaffManage";
		String path = fileFolder + fileName;
		String sqlFileName = sheetName + ".sql";
		String sqlFilePath = fileFolder + sqlFileName;
		// 是否自动生成ID
		Boolean idFlag = true;
		String charsetName = "GBK";
		GenSqlService.genSqlScriptFile(path, sheetName, idFlag, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptList_05() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = Constants.DATA_FILE_NAME;
		String sheetName = "PDRC_ProfileBaseInfo";
		String path = fileFolder + fileName;
		String sqlFileName = sheetName + ".sql";
		String sqlFilePath = fileFolder + sqlFileName;
		// 是否自动生成ID
		Boolean idFlag = false;
		String charsetName = "GBK";
		GenSqlService.genSqlScriptFile(path, sheetName, idFlag, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptList_06() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = Constants.DATA_FILE_NAME;
		String sheetName = "ISBG_Project";
		String path = fileFolder + fileName;
		String sqlFileName = sheetName + ".sql";
		String sqlFilePath = fileFolder + sqlFileName;
		// 是否自动生成ID
		Boolean idFlag = true;
		String charsetName = "GBK";
		GenSqlService.genSqlScriptFile(path, sheetName, idFlag, sqlFilePath, charsetName);
	}
	
	@Test
	public void testGenSqlScriptList_08() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = Constants.DATA_FILE_NAME;
		String sheetName = "PDRC_Profile";
		String path = fileFolder + fileName;
		String sqlFileName = sheetName + ".sql";
		String sqlFilePath = fileFolder + sqlFileName;
		// 是否自动生成ID
		Boolean idFlag = true;
		String charsetName = "GBK";
		GenSqlService.genSqlScriptFile(path, sheetName, idFlag, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptFileTotal_01() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = Constants.DATA_FILE_NAME;
		String path = fileFolder + fileName;
		String sqlFileName = "totalScript.sql";

		Map<String, Boolean> tableNameMap = new LinkedHashMap<String, Boolean>();
		String sqlFilePath = fileFolder + sqlFileName;

		String sheetName1 = "ISBG_Project";
		// 是否自动生成ID
		Boolean idFlag1 = false;
		tableNameMap.put(sheetName1, idFlag1);

		// String sheetName2 = "T_Users";
		// // 是否自动生成ID
		// Boolean idFlag2 = true;
		// tableNameMap.put(sheetName2, idFlag2);

		String sheetName3 = "PDRC_RM";
		// 是否自动生成ID
		Boolean idFlag3 = true;
		tableNameMap.put(sheetName3, idFlag3);

		String sheetName4 = "PDRC_TM";
		// 是否自动生成ID
		Boolean idFlag4 = true;
		tableNameMap.put(sheetName4, idFlag4);

		String sheetName5 = "PDRC_TM_SALARY";
		// 是否自动生成ID
		Boolean idFlag5 = true;
		tableNameMap.put(sheetName5, idFlag5);

		String sheetName6 = "PDRC_PDM";
		// 是否自动生成ID
		Boolean idFlag6 = true;
		tableNameMap.put(sheetName6, idFlag6);

		String sheetName7 = "PDRC_PGM";
		// 是否自动生成ID
		Boolean idFlag7 = true;
		tableNameMap.put(sheetName7, idFlag7);

		String sheetName8 = "PDRC_PM";
		// 是否自动生成ID
		Boolean idFlag8 = true;
		tableNameMap.put(sheetName8, idFlag8);

		String sheetName9 = "PDRC_StaffManage";
		// 是否自动生成ID
		Boolean idFlag9 = true;
		tableNameMap.put(sheetName9, idFlag9);

		String sheetName10 = "ISBG_HumanMap";
		// 是否自动生成ID
		Boolean idFlag10 = true;
		tableNameMap.put(sheetName10, idFlag10);

		String sheetName11 = "PDRC_BSM_Dispatch";
		// 是否自动生成ID
		Boolean idFlag11 = true;
		tableNameMap.put(sheetName11, idFlag11);

		String sheetName12 = "PDRC_B_ENPPRIZE";
		// 是否自动生成ID
		Boolean idFlag12 = true;
		tableNameMap.put(sheetName12, idFlag12);

		String sheetName13 = "ISBG_Project_Finish";
		// 是否自动生成ID
		Boolean idFlag13 = true;
		tableNameMap.put(sheetName13, idFlag13);

		String charsetName = "GBK";
		GenSqlService.genSqlScriptFileTotal(path, tableNameMap, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptFileTotal_02() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = "Data_20170531.xlsx";
		String path = fileFolder + fileName;
		String sqlFileName = "totalScript02.sql";

		Map<String, Boolean> tableNameMap = new LinkedHashMap<String, Boolean>();
		String sqlFilePath = fileFolder + sqlFileName;

		String sheetName1 = "PDRC_RM";
		// 是否自动生成ID
		Boolean idFlag1 = true;
		tableNameMap.put(sheetName1, idFlag1);

		String sheetName2 = "PDRC_TM";
		// 是否自动生成ID
		Boolean idFlag2 = true;
		tableNameMap.put(sheetName2, idFlag2);

		String sheetName3 = "PDRC_PDM";
		// 是否自动生成ID
		Boolean idFlag3 = true;
		tableNameMap.put(sheetName3, idFlag3);

		String sheetName4 = "PDRC_PGM";
		// 是否自动生成ID
		Boolean idFlag4 = true;
		tableNameMap.put(sheetName4, idFlag4);

		String sheetName5 = "PDRC_PM";
		// 是否自动生成ID
		Boolean idFlag5 = true;
		tableNameMap.put(sheetName5, idFlag5);

		String sheetName6 = "PDRC_StaffManage";
		// 是否自动生成ID
		Boolean idFlag6 = true;
		tableNameMap.put(sheetName6, idFlag6);

		String charsetName = "GBK";
		GenSqlService.genSqlScriptFileTotal(path, tableNameMap, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptFileTotal_03() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = "Data_20170531.xlsx";
		String path = fileFolder + fileName;
		String sqlFileName = "totalScript03.sql";

		Map<String, Boolean> tableNameMap = new LinkedHashMap<String, Boolean>();
		String sqlFilePath = fileFolder + sqlFileName;

		String sheetName1 = "T_Users";
		// 是否自动生成ID
		Boolean idFlag1 = false;
		tableNameMap.put(sheetName1, idFlag1);

		String charsetName = "GBK";
		GenSqlService.genSqlScriptFileTotal(path, tableNameMap, sqlFilePath, charsetName);
	}

	@Test
	public void testGenSqlScriptFileTotal_04() {
		logger.debug(Common.PROCESSING + fileFolder);
		String fileName = "Data_20170531.xlsx";
		String path = fileFolder + fileName;
		String sqlFileName = "totalScript04.sql";
		String sqlFilePath = fileFolder + sqlFileName;
		String charsetName = "GBK";
		GenSqlService.genSqlScriptFileTotal(path, sqlFilePath, charsetName);
	}

}
