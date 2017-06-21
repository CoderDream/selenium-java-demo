package com.coderdream.gensql.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.gensql.bean.TableStructure;
import com.coderdream.util.Common;
import com.coderdream.util.Constants;
import com.coderdream.util.ExcelUtil;

public class TableStructureService {

	private static final Logger logger = LoggerFactory.getLogger(TableStructureService.class);

	public List<TableStructure> getTableStructureList(String path) {
		List<TableStructure> list = null;
		logger.debug(Common.PROCESSING + path);
		try {
			list = ExcelUtil.readXlsx(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<TableStructure> getTableStructure(String fileName, String tableNameParam) {
		List<TableStructure> tableStructureList = new ArrayList<TableStructure>();
		logger.debug(Common.PROCESSING + fileName);
		List<TableStructure> list = getTableStructureList(
				getClass().getResource("../../../../").getFile().toString() + fileName);
		for (TableStructure tableStructure : list) {
			String tableName = tableStructure.getTableName();
			if (tableNameParam.equalsIgnoreCase(tableName)) {
				tableStructureList.add(tableStructure);
			}
		}

		return tableStructureList;
	}

	public String getColumnType(String tableNameParam, String columnNameParam) {
		List<TableStructure> list = getTableStructureList(
				getClass().getResource("../../../../").getFile().toString() + Constants.TABLE_STRUCTURE_FILE_NAME);
		for (TableStructure tableStructure : list) {
			String tableName = tableStructure.getTableName();
			String columnName = tableStructure.getColumnName();
			String type = tableStructure.getType();
			if (tableNameParam.equalsIgnoreCase(tableName) && columnNameParam.equalsIgnoreCase(columnName)) {
				return type;
			}
		}

		return "";
	}

	public List<TableStructure> getNotNullColumnList(String path, String tableNameParam) {
		List<TableStructure> tableStructureList = new ArrayList<TableStructure>();
		logger.debug(Common.PROCESSING + path);
		List<TableStructure> list = getTableStructureList(path);
		for (TableStructure tableStructure : list) {
			String tableName = tableStructure.getTableName();
			String nullFlag = tableStructure.getNullFlag();
			if (tableNameParam.equalsIgnoreCase(tableName) && (null == nullFlag || "".equals(nullFlag))) {
				tableStructureList.add(tableStructure);
			}
		}

		return tableStructureList;
	}
}
