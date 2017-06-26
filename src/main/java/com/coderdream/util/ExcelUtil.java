package com.coderdream.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.gensql.bean.IsbgHumanMap;
import com.coderdream.gensql.bean.IsbgProject;
import com.coderdream.gensql.bean.IsbgProjectFinish;
import com.coderdream.gensql.bean.IsbgProjectFinishComparator;
import com.coderdream.gensql.bean.PdrcBsmDispatch;
import com.coderdream.gensql.bean.PdrcEnpPrize;
import com.coderdream.gensql.bean.PdrcStaffManage;
import com.coderdream.gensql.bean.PdrcTmSalary;
import com.coderdream.gensql.bean.TableStructure;
import com.coderdream.gensql.service.DataService;

public class ExcelUtil {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ExcelUtil.class);

	/**
	 * read the Excel file
	 * 
	 * @param path
	 *            the path of the Excel file
	 * @return
	 * @throws IOException
	 */
	public static List<TableStructure> readExcel(String path)
			throws IOException {
		if (path == null || Common.EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = ExcelUtil.getPostfix(path);
			if (!Common.EMPTY.equals(postfix)) {
				if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path);
				} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(path);
				}
			} else {
				System.out.println(path + Common.NOT_EXCEL_FILE);
			}
		}
		return null;
	}

	/**
	 * Read the Excel 2010
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	public static List<TableStructure> readXlsx(String path)
			throws IOException {

		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		TableStructure tableStructure = null;
		List<TableStructure> list = new ArrayList<TableStructure>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook
				.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= xssfSheet
					.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					tableStructure = new TableStructure();
					// /** 表名 */
					// String tableName;
					// /** 字段名 */
					// String columnName;
					// /** 类型 */
					// String type;

					/** 表名 */
					XSSFCell tableName = xssfRow.getCell(0);
					/** 字段名 */
					XSSFCell columnName = xssfRow.getCell(2);
					/** 类型 */
					XSSFCell type = xssfRow.getCell(5);
					/** 允许空 */
					XSSFCell nullFlag = xssfRow.getCell(9);

					tableStructure.setTableName(getValue(tableName));
					tableStructure.setColumnName(getValue(columnName));
					tableStructure.setType(getValue(type));
					tableStructure.setNullFlag(getValue(nullFlag));
					list.add(tableStructure);
				}
			}
		}
		xssfWorkbook.close();
		return list;
	}

	/**
	 * Read the Excel 2010
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readAllData(String path, String sheetName)
			throws IOException {

		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

		// Read the Sheet
		XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
		if (xssfSheet == null) {
			xssfWorkbook.close();
			return null;
		}

		List<String[]> arrayList = readXSSFSheet(xssfSheet, 0);

		xssfWorkbook.close();
		return arrayList;
	}

	private static List<String[]> readXSSFSheet(XSSFSheet xssfSheet,
			Integer beginIndex) {
		List<String[]> arrayList = new ArrayList<String[]>();
		// Read the Row
		for (int rowNum = beginIndex; rowNum <= xssfSheet
				.getLastRowNum(); rowNum++) {
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if (xssfRow != null) {
				short minColIx = xssfRow.getFirstCellNum();
				short maxColIx = xssfRow.getLastCellNum();
				int size = maxColIx - minColIx;
				String[] strArray = new String[size];

				for (short colIx = minColIx; colIx < maxColIx; colIx++) {
					XSSFCell cell = xssfRow.getCell(colIx,
							MissingCellPolicy.RETURN_BLANK_AS_NULL);
					if (cell == null) {
						continue;
					}
					try {
						strArray[colIx] = getValue(xssfRow.getCell(colIx,
								MissingCellPolicy.RETURN_BLANK_AS_NULL));
						// ... do something with cell
					} catch (ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
					}
				}

				arrayList.add(strArray);
			}
		}

		return arrayList;
	}

	/**
	 * Read the Excel 2010
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readData(String path, String sheetName)
			throws IOException {

		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

		// Read the Sheet
		XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
		if (xssfSheet == null) {
			xssfWorkbook.close();
			return null;
		}

		List<String[]> arrayList = readXSSFSheet(xssfSheet, 0);

		xssfWorkbook.close();
		arrayList.remove(0);
		return arrayList;
	}

	/**
	 * Read the Excel 2003-2007
	 * 
	 * @param path
	 *            the path of the Excel
	 * @return
	 * @throws IOException
	 */
	public static List<TableStructure> readXls(String path) throws IOException {

		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		TableStructure tableStructure = null;
		List<TableStructure> list = new ArrayList<TableStructure>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook
				.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= hssfSheet
					.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					tableStructure = new TableStructure();
					// HSSFCell no = hssfRow.getCell(0);
					// HSSFCell name = hssfRow.getCell(1);
					// HSSFCell age = hssfRow.getCell(2);
					// HSSFCell score = hssfRow.getCell(3);
					// tableStructure.setNo(getValue(no));
					// tableStructure.setName(getValue(name));
					// tableStructure.setAge(getValue(age));
					// tableStructure.setScore(Float.valueOf(getValue(score)));
					list.add(tableStructure);
				}
			}
		}
		hssfWorkbook.close();
		return list;
	}

	private static String getValue(XSSFCell cell) {
		String result = "";
		if (null != cell) {
			// if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
			// return String.valueOf(cell.getBooleanCellValue());
			// } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
			// String cellValue = "";
			// if (HSSFDateUtil.isCellDateFormatted(cell)) { // 判断是日期类型
			// SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd
			// hh:mm:ss");
			// Date dt = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());//
			// 获取成DATE类型
			// cellValue = dateformat.format(dt);
			// } else {
			// DecimalFormat df = new DecimalFormat("0.00");
			// cellValue = df.format(cell.getNumericCellValue());
			// if (cellValue.indexOf(".") > 0) {
			// // 正则表达
			// cellValue = cellValue.replaceAll("0+?$", "");// 去掉后面无用的零
			// cellValue = cellValue.replaceAll("[.]$", "");// 如小数点后面全是零则去掉小数点
			// }
			// }
			//
			// return cellValue;
			// } else {
			// return String.valueOf(cell.getStringCellValue().trim()); // TODO
			// }

			// Alternatively, get the value and format it yourself
			switch (cell.getCellTypeEnum()) {
			case STRING:
				// System.out.println("StringCellValue\t" +
				// cell.getRichStringCellValue().getString());
				result = cell.getRichStringCellValue().getString();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					// System.out.println("DateCellValue\t" +
					// cell.getDateCellValue());
					// SimpleDateFormat dateformat = new
					// SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
					DateFormat dateformat = new SimpleDateFormat(
							Constants.SIMPLE_DATE_FORMAT);
					Date dt = HSSFDateUtil
							.getJavaDate(cell.getNumericCellValue());// 获取成DATE类型
					result = dateformat.format(dt);
				} else {
					// System.out.println("NumericCellValue\t" +
					// cell.getNumericCellValue());
					DecimalFormat df = new DecimalFormat("0.00");
					result = df.format(cell.getNumericCellValue());
					if (result.indexOf(".") > 0) {
						// 正则表达
						result = result.replaceAll("0+?$", "");// 去掉后面无用的零
						result = result.replaceAll("[.]$", "");// 如小数点后面全是零则去掉小数点
					}
				}
				break;
			case BOOLEAN:
				// System.out.println("BooleanCellValue\t" +
				// cell.getBooleanCellValue());
				result = Boolean.toString(cell.getBooleanCellValue());
				break;
			case FORMULA:
				CellType cy = cell.getCachedFormulaResultTypeEnum();
				// System.out.println("cy: " + cy);
				if (CellType.NUMERIC == cy) {
					// System.out.println("FormulaCellValue\t" +
					// String.valueOf(cell.getNumericCellValue()));
					result = String.valueOf(cell.getNumericCellValue());
				}

				if (CellType.STRING == cy) {
					result = cell.getStringCellValue();
					// System.out.println("FormulaCellValue\t" + result);
				}

				// System.out.println("FormulaCellValue\t" +
				// cell.getCellFormula());
				break;
			case BLANK:
				System.out.println();
				break;
			default:
				System.out.println();
			}
		} else {
			return "";
		}

		return result;
	}

	// @SuppressWarnings({ "static-access", "deprecation" })
	// private static String getValue(HSSFCell hssfCell) {
	// if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	// return String.valueOf(hssfCell.getBooleanCellValue());
	// } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	// return String.valueOf(hssfCell.getNumericCellValue());
	// } else {
	// return String.valueOf(hssfCell.getStringCellValue());
	// }
	// }

	/**
	 * get postfix of the path
	 * 
	 * @param path
	 * @return
	 */
	public static String getPostfix(String path) {
		if (path == null || Common.EMPTY.equals(path.trim())) {
			return Common.EMPTY;
		}
		if (path.contains(Common.POINT)) {
			return path.substring(path.lastIndexOf(Common.POINT) + 1,
					path.length());
		}
		return Common.EMPTY;
	}

	public static void readingAndRewritingIsbgProjectInfo(String path) {
		// TODO
		List<IsbgProject> totalIsbgProjectList = DataService
				.getIsbgProjectListInfo(path);
		Map<String, IsbgProject> isbgProjectMap = DataService
				.getIsbgProjectMap(totalIsbgProjectList);

		List<IsbgProjectFinish> isbgProjectFinishList = new ArrayList<IsbgProjectFinish>();
		List<IsbgHumanMap> isbgHumanMapList = DataService
				.getIsbgHumanMapListInfo(path, isbgProjectMap);
		List<PdrcBsmDispatch> pdrcBsmDispatchList = DataService
				.getPdrcBsmDispatchList(path, isbgHumanMapList);
		List<PdrcEnpPrize> pdrcEnpPrizeList = DataService
				.getPdrcEnpPrizeList(path, isbgHumanMapList);
		Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap = DataService
				.getPdrcStaffManageListMap(path);

		String startDateString = Constants.PROJECT_START_DATE;
		String endDateString = Constants.PROJECT_END_DATE;
		List<PdrcTmSalary> pdrcTmSalaryList = DataService
				.getPdrcTmSalaryListWithDateRange(pdrcStaffManageListMap,
						startDateString, endDateString);

		XSSFWorkbook xssfWorkbook = null;
		InputStream inp = null;
		try {
			inp = new FileInputStream(path);
			xssfWorkbook = new XSSFWorkbook(inp);
			// One ISBG_Project
			writeSheetIsbgProject(isbgProjectMap, isbgProjectFinishList,
					xssfWorkbook);

			// Two
			Collections.sort(isbgProjectFinishList,
					new IsbgProjectFinishComparator());
			writeSheetIsbgProjectFinish(isbgProjectFinishList, xssfWorkbook);

			// Three
			writeSheetIsbgHumanMap(isbgHumanMapList, xssfWorkbook);

			// Four PDRC_BSM_Dispatch
			writeSheetPdrcBsmDispatch(pdrcBsmDispatchList, xssfWorkbook);

			// Five PDRC_B_ENPPRIZE
			writeSheetPdrcEnpPrize(pdrcEnpPrizeList, xssfWorkbook);

			// Six PDRC_TM_SALARY
			writeSheetPdrcTmSalary(pdrcTmSalaryList, xssfWorkbook);

			// Write the output to a file
			FileOutputStream fileOut = new FileOutputStream(path);
			xssfWorkbook.write(fileOut);
			fileOut.close();
			inp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} finally {
			try {
				xssfWorkbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void writeSheetIsbgProject(
			Map<String, IsbgProject> isbgProjectMap,
			List<IsbgProjectFinish> isbgProjectFinishList,
			XSSFWorkbook xssfWorkbook) throws IOException {
		String sheetName1 = "ISBG_Project";
		XSSFSheet xssfSheet1 = xssfWorkbook.getSheet(sheetName1);
		if (xssfSheet1 == null) {
			xssfWorkbook.close();
		}

		// Read the Row
		for (int rowNum = 1; rowNum <= xssfSheet1.getLastRowNum(); rowNum++) {
			XSSFRow xssfRow = xssfSheet1.getRow(rowNum);
			if (xssfRow != null) {
				XSSFCell cell = xssfRow.getCell(0,
						MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (cell == null) {
					System.out.println("EERRR");
					break;
				}
				String projectNo = getValue(cell);
				IsbgProject isbgProject = isbgProjectMap.get(projectNo);
				System.out.println(isbgProject);
				// 0.ID
				// 1.ProjectNewNo
				// 2.ProjectName
				// 3.ProjectMgr_WorkID
				// 4.ProjectMgr_Name

				// 5.ProjectStartDateTime
				String projectStartDateTime = isbgProject
						.getProjectStartDateTime();
				XSSFCell cell5 = xssfRow.createCell(5);
				cell5.setCellType(CellType.STRING);
				cell5.setCellValue(projectStartDateTime);

				// 6.ProjectEndDateTime
				String projectEndDateTime = isbgProject.getProjectEndDateTime();
				XSSFCell cell6 = xssfRow.createCell(6);
				cell6.setCellType(CellType.STRING);
				cell6.setCellValue(projectEndDateTime);

				// 7.PDRC
				String pdrd = isbgProject.getPdrc();
				XSSFCell cell7 = xssfRow.createCell(7);
				cell7.setCellType(CellType.STRING);
				cell7.setCellValue(pdrd);

				// 8.IsFinish
				String isFinish = isbgProject.getIsFinish();
				XSSFCell cell8 = xssfRow.createCell(8);
				cell8.setCellType(CellType.STRING);
				cell8.setCellValue(isFinish);
				if ("true".equals(isFinish)) {
					IsbgProjectFinish isbgProjectFinish = new IsbgProjectFinish();
					isbgProjectFinish
							.setProjectStartDateTime(projectStartDateTime);
					isbgProjectFinish.setProjectEndDateTime(projectEndDateTime);
					isbgProjectFinish.setProjectId(isbgProject.getProjectId());
					isbgProjectFinishList.add(isbgProjectFinish);
				}
			}
		}
	}

	private static void writeSheetIsbgProjectFinish(
			List<IsbgProjectFinish> isbgProjectFinishList,
			XSSFWorkbook xssfWorkbook) throws IOException {
		// Two
		String sheetName2 = "ISBG_Project_Finish";
		XSSFSheet xssfSheet2 = xssfWorkbook.getSheet(sheetName2);
		if (xssfSheet2 == null) {
			xssfWorkbook.close();
		}

		// Read the Row
		int rowSize = isbgProjectFinishList.size();
		for (int rowNum = 1; rowNum <= rowSize; rowNum++) {
			XSSFRow xssfRow = xssfSheet2.createRow(rowNum);
			if (xssfRow != null) {
				IsbgProjectFinish isbgProjectFinish = isbgProjectFinishList
						.get(rowNum - 1);

				// 0.ProjectStartDateTime
				String projectStartDateTime = isbgProjectFinish
						.getProjectStartDateTime();
				XSSFCell cell0 = xssfRow.createCell(0);
				cell0.setCellType(CellType.STRING);
				cell0.setCellValue(projectStartDateTime);

				// 1.ProjectEndDateTime
				String projectEndDateTime = isbgProjectFinish
						.getProjectEndDateTime();
				XSSFCell cell1 = xssfRow.createCell(1);
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue(projectEndDateTime);

				// 2.projectId
				String projectId = isbgProjectFinish.getProjectId();
				XSSFCell cell2 = xssfRow.createCell(2);
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue(projectId);
			}
		}
	}

	// ISBG_HumanMap
	private static void writeSheetIsbgHumanMap(
			List<IsbgHumanMap> isbgHumanMapList, XSSFWorkbook xssfWorkbook)
			throws IOException {
		// Three
		String sheetName2 = "ISBG_HumanMap";
		XSSFSheet xssfSheet2 = xssfWorkbook.getSheet(sheetName2);
		if (xssfSheet2 == null) {
			xssfWorkbook.close();
		}

		// Read the Row
		int rowSize = isbgHumanMapList.size();
		for (int rowNum = 1; rowNum <= rowSize; rowNum++) {
			XSSFRow xssfRow = xssfSheet2.createRow(rowNum);
			if (xssfRow != null) {
				IsbgHumanMap isbgHumanMap = isbgHumanMapList.get(rowNum - 1);

				String staffWorkID = isbgHumanMap.getStaffWorkID();
				XSSFCell cell0 = xssfRow.createCell(0);
				cell0.setCellType(CellType.STRING);
				cell0.setCellValue(staffWorkID);

				String staffName = isbgHumanMap.getStaffName();
				XSSFCell cell1 = xssfRow.createCell(1);
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue(staffName);

				String projectID = isbgHumanMap.getProjectID();
				XSSFCell cell2 = xssfRow.createCell(2);
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue(projectID);

				String inProDate = isbgHumanMap.getInProDate();
				XSSFCell cell3 = xssfRow.createCell(3);
				cell3.setCellType(CellType.STRING);
				cell3.setCellValue(inProDate);

				String inProState = isbgHumanMap.getInProState();
				XSSFCell cell4 = xssfRow.createCell(4);
				cell4.setCellType(CellType.STRING);
				cell4.setCellValue(inProState);

				String outProDate = isbgHumanMap.getOutProDate();
				XSSFCell cell5 = xssfRow.createCell(5);
				cell5.setCellType(CellType.STRING);
				cell5.setCellValue(outProDate);

				String predictOutProDate = isbgHumanMap.getPredictOutProDate();
				XSSFCell cell6 = xssfRow.createCell(6);
				cell6.setCellType(CellType.STRING);
				cell6.setCellValue(predictOutProDate);

				String isPay = isbgHumanMap.getIsPay();
				XSSFCell cell7 = xssfRow.createCell(7);
				cell7.setCellType(CellType.STRING);
				cell7.setCellValue(isPay);
			}
		}
	}

	private static void writeSheetPdrcBsmDispatch(
			List<PdrcBsmDispatch> pdrcBsmDispatchList,
			XSSFWorkbook xssfWorkbook) throws IOException {
		String sheetName2 = "PDRC_BSM_Dispatch";
		XSSFSheet xssfSheet2 = xssfWorkbook.getSheet(sheetName2);
		if (xssfSheet2 == null) {
			xssfWorkbook.close();
		}

		// Read the Row
		int rowSize = pdrcBsmDispatchList.size();
		for (int rowNum = 1; rowNum <= rowSize; rowNum++) {
			XSSFRow xssfRow = xssfSheet2.createRow(rowNum);
			if (xssfRow != null) {
				PdrcBsmDispatch pdrcBsmDispatch = pdrcBsmDispatchList
						.get(rowNum - 1);

				String projectID = pdrcBsmDispatch.getProjectID();
				XSSFCell cell0 = xssfRow.createCell(0);
				cell0.setCellType(CellType.STRING);
				cell0.setCellValue(projectID);

				String staffWorkID = pdrcBsmDispatch.getStaffWorkID();
				XSSFCell cell1 = xssfRow.createCell(1);
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue(staffWorkID);

				String dispatchMonth = pdrcBsmDispatch.getDispatchMonth();
				XSSFCell cell2 = xssfRow.createCell(2);
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue(dispatchMonth);

				String confrimTime = pdrcBsmDispatch.getConfrimTime();
				XSSFCell cell3 = xssfRow.createCell(3);
				cell3.setCellType(CellType.STRING);
				cell3.setCellValue(confrimTime);

				String bsmState = pdrcBsmDispatch.getBsmState();
				XSSFCell cell4 = xssfRow.createCell(4);
				cell4.setCellType(CellType.STRING);
				cell4.setCellValue(bsmState);

				String bsm = pdrcBsmDispatch.getBsm();
				XSSFCell cell5 = xssfRow.createCell(5);
				cell5.setCellType(CellType.STRING);
				cell5.setCellValue(bsm);
			}
		}
	}

	// PDRC_B_ENPPRIZE
	private static void writeSheetPdrcEnpPrize(
			List<PdrcEnpPrize> pdrcEnpPrizeList, XSSFWorkbook xssfWorkbook)
			throws IOException {
		String sheetName2 = "PDRC_B_ENPPRIZE";
		XSSFSheet xssfSheet2 = xssfWorkbook.getSheet(sheetName2);
		if (xssfSheet2 == null) {
			xssfWorkbook.close();
		}

		// Read the Row
		int rowSize = pdrcEnpPrizeList.size();
		for (int rowNum = 1; rowNum <= rowSize; rowNum++) {
			XSSFRow xssfRow = xssfSheet2.createRow(rowNum);
			if (xssfRow != null) {
				PdrcEnpPrize pdrcBsmDispatch = pdrcEnpPrizeList.get(rowNum - 1);
				String workID = pdrcBsmDispatch.getWorkID();
				XSSFCell cell0 = xssfRow.createCell(0);
				cell0.setCellType(CellType.STRING);
				cell0.setCellValue(workID);

				String monthDate = pdrcBsmDispatch.getMonthDate();
				XSSFCell cell1 = xssfRow.createCell(1);
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue(monthDate);

				String prize = pdrcBsmDispatch.getPrize();
				XSSFCell cell2 = xssfRow.createCell(2);
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue(prize);
			}
		}
	}

	// PDRC_TM_SALARY
	private static void writeSheetPdrcTmSalary(
			List<PdrcTmSalary> pdrcTmSalaryList, XSSFWorkbook xssfWorkbook)
			throws IOException {
		String sheetName2 = "PDRC_TM_SALARY";
		XSSFSheet xssfSheet2 = xssfWorkbook.getSheet(sheetName2);
		if (xssfSheet2 == null) {
			xssfWorkbook.close();
		}

		// Read the Row
		int rowSize = pdrcTmSalaryList.size();
		for (int rowNum = 1; rowNum <= rowSize; rowNum++) {
			XSSFRow xssfRow = xssfSheet2.createRow(rowNum);
			if (xssfRow != null) {
				PdrcTmSalary pdrcTmSalary = pdrcTmSalaryList.get(rowNum - 1);
				String tmWorkID = pdrcTmSalary.getTmWorkID();
				XSSFCell cell0 = xssfRow.createCell(0);
				cell0.setCellType(CellType.STRING);
				cell0.setCellValue(tmWorkID);

				String monthDate = pdrcTmSalary.getMonthDate();
				XSSFCell cell1 = xssfRow.createCell(1);
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue(monthDate);

				String averageSalary = pdrcTmSalary.getAverageSalary();
				XSSFCell cell2 = xssfRow.createCell(2);
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue(averageSalary);
			}
		}
	}

	// PdrcStaffManage
}
