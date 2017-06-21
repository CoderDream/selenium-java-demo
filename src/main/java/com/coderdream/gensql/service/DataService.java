package com.coderdream.gensql.service;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.gensql.bean.IsbgHumanMap;
import com.coderdream.gensql.bean.IsbgHumanMapComparator;
import com.coderdream.gensql.bean.IsbgProject;
import com.coderdream.gensql.bean.MemberParticipate;
import com.coderdream.gensql.bean.MemberParticipateComparator;
import com.coderdream.gensql.bean.Menu;
import com.coderdream.gensql.bean.PdrcBsmDispatch;
import com.coderdream.gensql.bean.PdrcBsmDispatchComparator;
import com.coderdream.gensql.bean.PdrcEnpPrize;
import com.coderdream.gensql.bean.PdrcEnpPrizeComparator;
import com.coderdream.gensql.bean.PdrcStaffManage;
import com.coderdream.gensql.bean.PdrcTm;
import com.coderdream.gensql.bean.PdrcTmSalary;
import com.coderdream.gensql.bean.PdrcTmSalaryComparator;
import com.coderdream.gensql.bean.PmTmRelation;
import com.coderdream.gensql.bean.Role;
import com.coderdream.util.Constants;
import com.coderdream.util.DateUtil;
import com.coderdream.util.ExcelUtil;
import com.coderdream.util.MathUtil;
import com.coderdream.util.RedPacketUtil;

public class DataService {

	private static final Logger logger = LoggerFactory.getLogger(DataService.class);

	public List<PdrcTm> getPdrcTmList(String path) {
		List<PdrcTm> list = null;
		String sheetName = "PDRC_TM";
		try {
			List<String[]> arrayList = ExcelUtil.readAllData(path, sheetName);
			if (null != arrayList && 1 < arrayList.size()) {
				list = new ArrayList<PdrcTm>();
			}
			for (int i = 1; i < arrayList.size(); i++) {
				PdrcTm rdrcTm = new PdrcTm();
				String[] arrayStr = arrayList.get(i);
				String workID = arrayStr[0];
				rdrcTm.setWorkID(workID);
				String rmWorkID = arrayStr[1];
				rdrcTm.setRmWorkID(rmWorkID);

				list.add(rdrcTm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<PdrcStaffManage> getPdrcStaffManageList(String path) {
		List<PdrcStaffManage> list = null;

		String sheetName = "PDRC_StaffManage";
		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				list = new ArrayList<PdrcStaffManage>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				PdrcStaffManage pdrcStaffManage = new PdrcStaffManage();
				String[] arrayStr = arrayList.get(i);
				String workID = arrayStr[0];
				pdrcStaffManage.setWorkID(workID);
				String tmWorkID = arrayStr[2];
				pdrcStaffManage.setTmWorkID(tmWorkID);
				String normalMam = arrayStr[4];
				String salary = arrayStr[8];
				pdrcStaffManage.setNormalMam(normalMam);
				pdrcStaffManage.setSalary(salary);

				list.add(pdrcStaffManage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<PdrcStaffManage> getPdrcStaffManageList(String path, String sheetName) {
		List<PdrcStaffManage> drcStaffManageList = null;

		// String sheetName = "PDRC_StaffManage";
		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				drcStaffManageList = new ArrayList<PdrcStaffManage>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				PdrcStaffManage pdrcStaffManage = new PdrcStaffManage();
				String[] arrayStr = arrayList.get(i);

				/** 员工号 */
				String workID = arrayStr[0];
				/** 员工姓名 */
				String userName = arrayStr[1];
				/** 标准人定额 */
				String normalMam = arrayStr[2];
				/** TM工号 */
				String tmWorkID = arrayStr[3];
				/** TM姓名 */
				String tmName = arrayStr[4];

				pdrcStaffManage.setWorkID(workID);
				pdrcStaffManage.setUserName(userName);
				pdrcStaffManage.setNormalMam(normalMam);
				pdrcStaffManage.setTmWorkID(tmWorkID);
				pdrcStaffManage.setTmName(tmName);

				drcStaffManageList.add(pdrcStaffManage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return drcStaffManageList;
	}

	public static List<Role> getRoleList(String path, String sheetName) {
		List<Role> roleList = null;

		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				roleList = new ArrayList<Role>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				Role role = new Role();
				String[] arrayStr = arrayList.get(i);

				String workID = arrayStr[0];

				String roleName = arrayStr[1];

				role.setWorkID(workID);
				role.setRole(roleName);

				roleList.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return roleList;
	}

	public static List<Menu> getMenuList(String path, String sheetName) {
		List<Menu> menuList = null;

		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				menuList = new ArrayList<Menu>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				Menu menu = new Menu();
				String[] arrayStr = arrayList.get(i);
				String role = arrayStr[0];
				String menuName = arrayStr[1];
				menu.setRole(role);
				menu.setMenuName(menuName);
				menuList.add(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuList;
	}
	
	public Map<String, List<String>> getRoleMenuNameMap(List<Menu> menuList) {
		Map<String, List<String>> menuNameListMap = new HashMap<String, List<String>>();
		List<String> menuNameList = null;
		System.out.println(menuList.size());
		for (Menu menu : menuList) {
			System.out.println(menu);
			menuNameList = menuNameListMap.get(menu.getRole());
			if(null == menuNameList) {
				menuNameList = new ArrayList<String>();
			}
			menuNameList.add(menu.getMenuName());
			menuNameListMap.put(menu.getRole(), menuNameList);
		}
		
		return menuNameListMap;
	}
	
	public static Map<String, List<String>> getWorkIdMenuNameMap(List<Role> roleList, List<Menu> menuList) {
		//Map<String, List<String>> menuNameListMapResult = new LinkedHashMap<String, List<String>>();
		Map<String, List<String>> menuNameListMapResult = new HashMap<String, List<String>>();
		Map<String, List<String>> menuNameListMap = new HashMap<String, List<String>>();
		
		List<String> menuNameList = null;
		System.out.println(menuList.size());
		for (Menu menu : menuList) {
			System.out.println(menu);
			menuNameList = menuNameListMap.get(menu.getRole());
			if(null == menuNameList) {
				menuNameList = new ArrayList<String>();
			}
			menuNameList.add(menu.getMenuName());
			menuNameListMap.put(menu.getRole(), menuNameList);
		}
		
		for (Role role : roleList) {
			menuNameListMapResult.put(role.getWorkID(), menuNameListMap.get(role.getRole()));
		}
		
		return menuNameListMapResult;
	}

	public static List<PmTmRelation> getPmTmRelationList(String path) {
		List<PmTmRelation> pmTmRelationList = null;
		List<String> pmList = null;


		String sheetName = "PDRC_PM";
		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				// logger.debug("Size: \t" + arrayList.size());
				pmList = new ArrayList<String>();

				for (int i = 0; i < arrayList.size(); i++) {
					String[] arrayStr = arrayList.get(i);
					String workID = arrayStr[0];
					pmList.add(workID);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap = getPdrcStaffManageListMap(path);

		if (pdrcStaffManageListMap.size() > 0) {
			pmTmRelationList = new ArrayList<PmTmRelation>();
		}
		int index = 0;
		PmTmRelation pmRmRelation = null;
		List<String> workIDList = null;
		for (String key : pdrcStaffManageListMap.keySet()) {

			pmRmRelation = new PmTmRelation();
			List<PdrcStaffManage> pdrcStaffManageList = pdrcStaffManageListMap.get(key);
			String pmWorkID = pmList.get(index++);
			pmRmRelation.setPmWorkID(pmWorkID);
			pmRmRelation.setTmWorkID(key);

			// System.out.println("RM WorkId\t" + key);
			workIDList = new ArrayList<String>();
			// workIDList.add(key);
			for (PdrcStaffManage pdrcStaffManage : pdrcStaffManageList) {
				// System.out.println("WorkId\t\t" +
				// pdrcStaffManage.getWorkID());
				workIDList.add(pdrcStaffManage.getWorkID());
				pmRmRelation.setWorkIDList(workIDList);
			}

			pmTmRelationList.add(pmRmRelation);
		}

		return pmTmRelationList;
	}

	public static Map<String, List<String>> getPmWorkIDListMap(String path) {
		Map<String, List<String>> pmWorkIDListMap = new HashMap<String, List<String>>();
		List<PmTmRelation> pmRmRelationList = DataService.getPmTmRelationList(path);

		for (PmTmRelation pmRmRelation : pmRmRelationList) {
			String pmWorkID = pmRmRelation.getPmWorkID();
			List<String> workIDList = pmRmRelation.getWorkIDList();
			pmWorkIDListMap.put(pmWorkID, workIDList);
		}

		return pmWorkIDListMap;
	}

	public static String getTmWorkIDByPmWorkID(String path, String pmWorkIDParam) {
		String tmWorkID = "";
		List<PmTmRelation> pmRmRelationList = DataService.getPmTmRelationList(path);

		for (PmTmRelation pmRmRelation : pmRmRelationList) {
			String pmWorkID = pmRmRelation.getPmWorkID();

			if (pmWorkIDParam.equals(pmWorkID)) {
				tmWorkID = pmRmRelation.getTmWorkID();
				break;
			}
		}

		return tmWorkID;
	}

	public static Map<String, String> getPmWorkIDTmWorkIDMap(String path) {
		Map<String, String> pmWorkIDTmWorkIDMap = new TreeMap<String, String>();
		List<PmTmRelation> pmRmRelationList = DataService.getPmTmRelationList(path);

		for (PmTmRelation pmRmRelation : pmRmRelationList) {
			String pmWorkID = pmRmRelation.getPmWorkID();
			String tmWorkID = pmRmRelation.getTmWorkID();
			pmWorkIDTmWorkIDMap.put(pmWorkID, tmWorkID);

		}

		return pmWorkIDTmWorkIDMap;
	}

	/**
	 * @param path
	 * @return
	 */
	public static Map<String, List<PdrcStaffManage>> getPdrcStaffManageListMap(String path) {
		Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap = new TreeMap<String, List<PdrcStaffManage>>();
		List<PdrcStaffManage> pdrcStaffManageList = null;

		String sheetName = "PDRC_StaffManage";
		try {
			List<String[]> arrayList = ExcelUtil.readAllData(path, sheetName);
			if (null != arrayList && 1 < arrayList.size()) {
				for (int i = 1; i < arrayList.size(); i++) {
					PdrcStaffManage pdrcStaffManage = new PdrcStaffManage();
					String[] arrayStr = arrayList.get(i);
					String tmWorkID = arrayStr[0];
					pdrcStaffManage.setTmWorkID(tmWorkID);
					String workID = arrayStr[2];
					pdrcStaffManage.setWorkID(workID);
					String normalMam = arrayStr[4];
					String salary = arrayStr[8];
					pdrcStaffManage.setNormalMam(normalMam);
					pdrcStaffManage.setSalary(salary);

					pdrcStaffManageList = pdrcStaffManageListMap.get(tmWorkID);

					if (null == pdrcStaffManageList) {
						pdrcStaffManageList = new ArrayList<PdrcStaffManage>();
					}

					pdrcStaffManageList.add(pdrcStaffManage);
					pdrcStaffManageListMap.put(tmWorkID, pdrcStaffManageList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pdrcStaffManageListMap;
	}

	/**
	 * @param path
	 * @return
	 */
	public static Double getBsmSumByTmWorkId(Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap,
			String tmWorkId) {
		Double sum = new Double(0);

		for (String key : pdrcStaffManageListMap.keySet()) {
			// System.out.println("TM WorkId\t" + key);
			if (tmWorkId.equals(key)) {
				List<PdrcStaffManage> pdrcStaffManageList = pdrcStaffManageListMap.get(key);
				for (PdrcStaffManage pdrcStaffManage : pdrcStaffManageList) {
					String normalMam = pdrcStaffManage.getNormalMam();
					Double normalMamDouble = Double.valueOf(normalMam);
					sum += normalMamDouble;
					// System.out.println("WorkId\t\t" +
					// pdrcStaffManage.getWorkID());
				}
			}
		}

		return sum;
	}

	public static List<PdrcTmSalary> getPdrcTmSalaryList(Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap) {
		List<PdrcTmSalary> pdrcTmSalaryList = new ArrayList<PdrcTmSalary>();
		List<PdrcStaffManage> pdrcStaffManageList = null;
		
		// Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap =
		// DataService.getPdrcStaffManageListMap(path);
		PdrcTmSalary pdrcTmSalary = null;
		for (String key : pdrcStaffManageListMap.keySet()) {

			pdrcStaffManageList = pdrcStaffManageListMap.get(key);
			pdrcTmSalary = new PdrcTmSalary();
			pdrcTmSalary.setTmWorkID(key);

			Integer totalSalaryValue = 0;
			int index = 1;
			for (PdrcStaffManage pdrcStaffManage : pdrcStaffManageList) {
				String salary = pdrcStaffManage.getSalary();
				totalSalaryValue += Integer.parseInt(salary);
				index++;
			}
			Integer averageSalaryValue = totalSalaryValue / index;
			pdrcTmSalary.setTotalSalary(totalSalaryValue.toString());
			pdrcTmSalary.setAverageSalary(averageSalaryValue.toString());
			pdrcTmSalaryList.add(pdrcTmSalary);
		}

		return pdrcTmSalaryList;
	}

	public static List<PdrcTmSalary> getPdrcTmSalaryListWithDateRange(
			Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap, String startDateString, String endDateString) {
		List<PdrcTmSalary> pdrcTmSalaryList = new ArrayList<PdrcTmSalary>();

		List<String> monthList = DateUtil.getMonthBetween(startDateString, endDateString);

		List<PdrcTmSalary> basePdrcTmSalaryList = DataService.getPdrcTmSalaryList(pdrcStaffManageListMap);
		PdrcTmSalary newPdrcTmSalary = null;
		try {
			for (String monthDate : monthList) {
				for (PdrcTmSalary pdrcTmSalary : basePdrcTmSalaryList) {
					newPdrcTmSalary = new PdrcTmSalary();
					BeanUtils.copyProperties(newPdrcTmSalary, pdrcTmSalary);
					newPdrcTmSalary.setMonthDate(monthDate);
					pdrcTmSalaryList.add(newPdrcTmSalary);
				}
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		Collections.sort(pdrcTmSalaryList, new PdrcTmSalaryComparator());

		return pdrcTmSalaryList;
	}

	public static Map<String, String> getWorkIDBsmMap(String path) {
		Map<String, String> workIDBsmMap = new HashMap<String, String>();

		String sheetName = "PDRC_StaffManage";
		try {
			List<String[]> arrayList = ExcelUtil.readAllData(path, sheetName);
			if (null != arrayList && 1 < arrayList.size()) {
				for (int i = 1; i < arrayList.size(); i++) {
					String[] arrayStr = arrayList.get(i);
					String workID = arrayStr[2];
					String bsm = arrayStr[4];
					workIDBsmMap.put(workID, bsm);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return workIDBsmMap;
	}

	public List<PdrcStaffManage> getPdrcStaffManageListByTmWorkId(
			Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap, String tmWorkIdParam) {
		// Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap =
		// getPdrcStaffManageListMap(path);
		List<PdrcStaffManage> pdrcStaffManageList = null;
		for (String key : pdrcStaffManageListMap.keySet()) {
			if (tmWorkIdParam.equalsIgnoreCase(key)) {
				pdrcStaffManageList = pdrcStaffManageListMap.get(key);
			}
		}

		return pdrcStaffManageList;
	}

	public static List<IsbgProject> getIsbgProjectList(String path) {
		List<IsbgProject> isbgProjectList = null;

		String sheetName = "ISBG_Project";
		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				isbgProjectList = new ArrayList<IsbgProject>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				IsbgProject isbgProject = new IsbgProject();
				String[] arrayStr = arrayList.get(i);

				String projectId = arrayStr[0];
				String projectNo = arrayStr[1];
				String projectName = arrayStr[2];
				String projectMgrWorkID = arrayStr[3];
				String projectMgrName = arrayStr[4];

				isbgProject.setProjectId(projectId);
				isbgProject.setProjectNo(projectNo);
				isbgProject.setProjectName(projectName);
				isbgProject.setProjectMgrWorkID(projectMgrWorkID);
				isbgProject.setProjectMgrName(projectMgrName);
				isbgProjectList.add(isbgProject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isbgProjectList;
	}

	public static Map<String, List<IsbgProject>> getIsbgProjectListMap(String path) {

		Map<String, List<IsbgProject>> isbgProjectListMap = new HashMap<String, List<IsbgProject>>();

		List<IsbgProject> isbgProjectList = getIsbgProjectList(path);
		for (IsbgProject isbgProject : isbgProjectList) {
			String projectMgrWorkID = isbgProject.getProjectMgrWorkID();
			List<IsbgProject> list = isbgProjectListMap.get(projectMgrWorkID);
			if (null == list) {
				list = new ArrayList<IsbgProject>();
			}
			list.add(isbgProject);

			isbgProjectListMap.put(isbgProject.getProjectMgrWorkID(), list);
		}

		return isbgProjectListMap;
	}

	public static List<IsbgProject> getIsbgProjectListInfo(String path) { // TODO
		List<IsbgProject> totalIsbgProjectList = new ArrayList<IsbgProject>();
		Map<String, List<IsbgProject>> isbgProjectListMap = getIsbgProjectListMap(path);
		Map<String, String> pmWorkIDTmWorkIDMap = DataService.getPmWorkIDTmWorkIDMap(path);
		Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap = DataService.getPdrcStaffManageListMap(path);
		for (String key : isbgProjectListMap.keySet()) {
			List<IsbgProject> isbgProjectList = isbgProjectListMap.get(key);

			String beginDateString = Constants.PROJECT_START_DATE;
			// 总和
			int total = DateUtil.getDateRange(beginDateString, Constants.PROJECT_END_DATE);
			// 个数
			int count = isbgProjectList.size();
			// 最小额度
			int min = Constants.PROJECT_PERIOD_MIN;
			// 最大额度
			int max = Constants.PROJECT_PERIOD_MAX;
			// 最大额度是平均值的倍数
			double time = Constants.PROJECT_PERIOD_AVG_TIMES;

			List<Integer> integerList = RedPacketUtil.splitRedPackets(total, count, min, max, time);
			logger.error("integerList\t" + integerList);
			List<String> dateStringList = RedPacketUtil.getDateStringList(beginDateString, integerList);
			for (int i = 0; i < count; i++) {
				IsbgProject isbgProject = isbgProjectList.get(i);

				String projectStartDateTime = dateStringList.get(i * 2);
				String projectEndDateTime = dateStringList.get(i * 2 + 1);
				isbgProject.setProjectStartDateTime(projectStartDateTime);
				isbgProject.setProjectEndDateTime(projectEndDateTime);

				Double participateSum = DateUtil.getMonthBetweenParticipateSum(isbgProject.getProjectStartDateTime(),
						isbgProject.getProjectEndDateTime());

				String tmWorkID = pmWorkIDTmWorkIDMap.get(isbgProject.getProjectMgrWorkID());
				Double bsmSumTeam = DataService.getBsmSumByTmWorkId(pdrcStaffManageListMap, tmWorkID);

				// 计算得到项目预算：周期之和*BSM之和
				Double bsmSum = participateSum * bsmSumTeam;

				// 计算
				Double pdrc = bsmSum * Constants.PDRD_PRICE;
				Integer pdrcInteger = pdrc.intValue();
				isbgProject.setPdrc(pdrcInteger.toString());

				String isFinish = DateUtil.beforeToday(projectEndDateTime) ? "true" : "false";
				isbgProject.setIsFinish(isFinish);

				totalIsbgProjectList.add(isbgProject);
			}
		}

		return totalIsbgProjectList;
	}

	public static Map<String, IsbgProject> getIsbgProjectMap(List<IsbgProject> totalIsbgProjectList) {
		Map<String, IsbgProject> isbgProjectMap = new HashMap<String, IsbgProject>();

		// List<IsbgProject> totalIsbgProjectList =
		// DataService.getIsbgProjectListInfo(path);
		for (IsbgProject isbgProject : totalIsbgProjectList) {
			System.out.println(isbgProject);
			isbgProjectMap.put(isbgProject.getProjectId(), isbgProject);
		}

		return isbgProjectMap;
	}

	public static List<IsbgHumanMap> getIsbgHumanMapListBackup(String path) {
		// TODO
		List<IsbgHumanMap> isbgHumanMapList = new ArrayList<IsbgHumanMap>();


		String sheetName = "ISBG_HumanMap";
		try {
			List<String[]> arrayList = ExcelUtil.readAllData(path, sheetName);
			if (null != arrayList && 1 < arrayList.size()) {
				isbgHumanMapList = new ArrayList<IsbgHumanMap>();
			}
			for (int i = 1; i < arrayList.size(); i++) {
				IsbgHumanMap isbgHumanMap = new IsbgHumanMap();
				String[] arrayStr = arrayList.get(i);

				String staffWorkID = arrayStr[0];
				String staffName = arrayStr[1];
				String projectID = arrayStr[2];
				String inProDate = arrayStr[3];
				String inProState = arrayStr[4];
				String outProDate = arrayStr[5];
				String predictOutProDate = arrayStr[6];
				String isPay = arrayStr[7];

				isbgHumanMap.setStaffWorkID(staffWorkID);
				isbgHumanMap.setStaffName(staffName);
				isbgHumanMap.setProjectID(projectID);
				isbgHumanMap.setInProDate(inProDate);
				isbgHumanMap.setInProState(inProState);
				isbgHumanMap.setOutProDate(outProDate);
				isbgHumanMap.setPredictOutProDate(predictOutProDate);
				isbgHumanMap.setIsPay(isPay);

				isbgHumanMapList.add(isbgHumanMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Collections.sort(isbgHumanMapList, new IsbgHumanMapComparator());

		return isbgHumanMapList;
	}

	public static Map<String, Integer> getWorkingDaysMap(String path, Map<String, IsbgProject> isbgProjectMap) {
		Map<String, Integer> workIdDaysMap = new HashMap<String, Integer>();
		List<IsbgHumanMap> isbgHumanMapList = DataService.getIsbgHumanMapListInfo(path, isbgProjectMap);
		for (IsbgHumanMap isbgHumanMap : isbgHumanMapList) {

			String staffWorkID = isbgHumanMap.getStaffWorkID();

			String inProDate = isbgHumanMap.getInProDate();

			String predictOutProDate = isbgHumanMap.getPredictOutProDate();
			Integer count = DateUtil.getDateRange(inProDate, predictOutProDate);
			Integer total = 0;
			Integer temp = workIdDaysMap.get(staffWorkID);
			if (null == temp) {
				total = 0;
			} else {
				total = temp;
			}
			total += count;
			workIdDaysMap.put(staffWorkID, total);
		}

		return workIdDaysMap;
	}

	public static List<IsbgHumanMap> getIsbgHumanMapListInfo(String path, Map<String, IsbgProject> isbgProjectMap) {
		int count = 0;
		List<IsbgHumanMap> isbgHumanMapList = new ArrayList<IsbgHumanMap>();
		Map<String, List<String>> pmWorkIDListMap = DataService.getPmWorkIDListMap(path);

		// Map<String, IsbgProject> isbgProjectMap =
		// DataService.getIsbgProjectMap(path);
		IsbgHumanMap isbgHumanMap = null;
		for (String key : isbgProjectMap.keySet()) {
			IsbgProject isbgProject = isbgProjectMap.get(key);
			// System.out.println(isbgProject);

			String staffName = "NULL";

			String projectID = isbgProject.getProjectId();
			String pmWorkID = isbgProject.getProjectMgrWorkID();

			/** 项目开始时间 */
			String inProDate = isbgProject.getProjectStartDateTime();

			/** 项目预计结束时间 */
			String predictOutProDate = isbgProject.getProjectEndDateTime();

			/** 项目结束时间（如果项目预计结束时间在今天和今天之后，则为上项目，否则为下项目 */
			String inProState = "上项目";

			/** 项目结束时间（如果在今天和今天之后，则为NULL */
			String outProDate = "NULL";

			if (DateUtil.beforeToday(predictOutProDate)) {
				outProDate = predictOutProDate;
				inProState = "下项目 ";
			}

			/** 默认为true */
			String isPay = "true";

			List<String> workIDList = pmWorkIDListMap.get(pmWorkID);
			for (String workID : workIDList) {
				isbgHumanMap = new IsbgHumanMap();
				isbgHumanMap.setStaffWorkID(workID);
				isbgHumanMap.setStaffName(staffName);
				isbgHumanMap.setProjectID(projectID);
				isbgHumanMap.setInProDate(inProDate);
				isbgHumanMap.setInProState(inProState);
				isbgHumanMap.setOutProDate(outProDate);
				isbgHumanMap.setPredictOutProDate(predictOutProDate);
				isbgHumanMap.setIsPay(isPay);

				// TODO
				int randomNumber = MathUtil.getRandomByRange(Constants.IDEL_RANDOM_MIN, Constants.IDEL_RANDOM_MAX);
				// 如果随机数是4、5、6，就让他晚入项目这么多天
				if (Constants.IDEL_RANDOM_DAYS_MIN < randomNumber && randomNumber < Constants.IDEL_RANDOM_DAYS_MAX) {
					isbgHumanMap.setInProDate(DateUtil.getNextDate(inProDate, randomNumber));
					logger.error("############### \t" + workID + "\t" + inProDate + "\t"
							+ DateUtil.getNextDate(isbgHumanMap.getInProDate(), -1) + "\t" + randomNumber);
					count++;
				}

				isbgHumanMapList.add(isbgHumanMap);
			}
		}
		logger.error("getIsbgHumanMapListInfo idel count: " + count);
		Collections.sort(isbgHumanMapList, new IsbgHumanMapComparator());

		return isbgHumanMapList;
	}

	public static List<MemberParticipate> getMemberParticipateList(List<IsbgHumanMap> isbgHumanMapList) {
		List<MemberParticipate> memberParticipateList = new ArrayList<MemberParticipate>();
		// List<IsbgHumanMap> isbgHumanMapList =
		// DataService.getIsbgHumanMapListInfo(path);
		System.out.println(isbgHumanMapList.size());
		MemberParticipate memberParticipate = null;
		MemberParticipate newMemberParticipate = null;
		try {
			for (IsbgHumanMap isbgHumanMap : isbgHumanMapList) {
				// System.out.println(isbgHumanMap);
				memberParticipate = new MemberParticipate();
				String staffWorkID = isbgHumanMap.getStaffWorkID();
				String projectID = isbgHumanMap.getProjectID();
				String beginDateString = isbgHumanMap.getInProDate();
				String endDateString = isbgHumanMap.getPredictOutProDate();

				memberParticipate.setStaffWorkID(staffWorkID);
				memberParticipate.setProjectID(projectID);
				memberParticipate.setProjectStartDate(beginDateString);
				memberParticipate.setProjectEndDate(endDateString);

				Map<String, Double> participateMap = DateUtil.getMonthBetweenParticipateWithMonth(beginDateString,
						endDateString);

				for (String monthDate : participateMap.keySet()) {
					newMemberParticipate = new MemberParticipate();
					BeanUtils.copyProperties(newMemberParticipate, memberParticipate);
					Double participateValue = participateMap.get(monthDate);
					// System.out.println(monthDate + "\t" + participateValue);
					newMemberParticipate.setMonthDate(monthDate);
					newMemberParticipate.setParticipateRate(participateValue);

					memberParticipateList.add(newMemberParticipate);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		Collections.sort(memberParticipateList, new MemberParticipateComparator());
		return memberParticipateList;
	}

	public static Map<String, Double> getMemberParticipateMap(List<IsbgHumanMap> isbgHumanMapList) {
		Map<String, Double> memberParticipateMap = new TreeMap<String, Double>();

		List<MemberParticipate> memberParticipateList = DataService.getMemberParticipateList(isbgHumanMapList);
		System.out.println("size: \t" + memberParticipateList.size());
		for (MemberParticipate memberParticipate : memberParticipateList) {
			String projectID = memberParticipate.getProjectID();
			String staffWorkID = memberParticipate.getStaffWorkID();
			String monthDate = memberParticipate.getMonthDate();
			Double participateRate = memberParticipate.getParticipateRate();
			memberParticipateMap.put(projectID + ":" + staffWorkID + ":" + monthDate, participateRate);
		}

		return memberParticipateMap;
	}

	public static List<PdrcBsmDispatch> getPdrcBsmDispatchList(String path, List<IsbgHumanMap> isbgHumanMapList) {
		List<PdrcBsmDispatch> pdrcBsmDispatchList = new ArrayList<PdrcBsmDispatch>();
		// List<IsbgHumanMap> isbgHumanMapList =
		// DataService.getIsbgHumanMapListInfo(path);
		Map<String, String> workIDBsmMap = DataService.getWorkIDBsmMap(path);
		Map<String, Double> memberParticipateMap = DataService.getMemberParticipateMap(isbgHumanMapList);
		for (String key : memberParticipateMap.keySet()) {
			Double memberParticipateValue = memberParticipateMap.get(key);
			System.out.println(key + "\t" + memberParticipateValue);
		}

		PdrcBsmDispatch pdrcBsmDispatch = null;
		for (IsbgHumanMap isbgHumanMap : isbgHumanMapList) {
			String staffWorkID = isbgHumanMap.getStaffWorkID();
			String projectID = isbgHumanMap.getProjectID();
			String inProDate = isbgHumanMap.getInProDate();
			String predictOutProDate = isbgHumanMap.getPredictOutProDate();

			String bsmState = Constants.BSM_STATE_DEFAULT;
			String bsm = "0";

			List<String> dateList = DateUtil.getMonthBetween(inProDate, predictOutProDate);
			for (String monthStr : dateList) {
				pdrcBsmDispatch = new PdrcBsmDispatch();

				pdrcBsmDispatch.setProjectID(projectID);
				pdrcBsmDispatch.setStaffWorkID(staffWorkID);

				String dispatchMonth = monthStr;
				String confrimTime = "NULL";

				// 成员当月参与度
				Double memberParticipateValue = memberParticipateMap
						.get(projectID + ":" + staffWorkID + ":" + monthStr);
				if (null == memberParticipateValue) {
					System.out.println("#####");
					memberParticipateValue = new Double(1000);
				}

				// TODO 获取本月月末日期
				String monthEnd = DateUtil.getMonthEnd(monthStr);

				boolean compareResult = DateUtil.beforeDate(monthStr, monthEnd);

				// 已结项
				if (DateUtil.beforeToday(predictOutProDate)) {
					confrimTime = predictOutProDate;

					// 已评价
					bsmState = Constants.BSM_STATE_CONFIRM;

					int randomNumber = MathUtil.getRandomByRange(Constants.BSM_RATE_MIN, Constants.BSM_RATE_MAX);
					double dRandomNumber = randomNumber * 0.1;
					String baseBsm = workIDBsmMap.get(staffWorkID);

					Double dBsm = dRandomNumber * Double.parseDouble(baseBsm) * memberParticipateValue;

					if ("0.0".equals(dBsm.toString())) {
						System.out.println("#####");
					}

					bsm = MathUtil.setScale(dBsm, 2).toString();
				} // 未结项，但是上月需评价（BSM状态为【已分配】） TODO
				else if (compareResult) {
					confrimTime = "NULL";

					// 已评价
					bsmState = Constants.BSM_STATE_NOT_CONFIRM;

					int randomNumber = MathUtil.getRandomByRange(Constants.BSM_RATE_MIN, Constants.BSM_RATE_MAX);
					double dRandomNumber = randomNumber * 0.1;
					String baseBsm = workIDBsmMap.get(staffWorkID);

					Double dBsm = dRandomNumber * Double.parseDouble(baseBsm) * memberParticipateValue;

					if ("0.0".equals(dBsm.toString())) {
						System.out.println("#####");
					}

					bsm = MathUtil.setScale(dBsm, 2).toString();
				}

				pdrcBsmDispatch.setDispatchMonth(dispatchMonth);
				pdrcBsmDispatch.setConfrimTime(confrimTime);
				pdrcBsmDispatch.setBsmState(bsmState);
				pdrcBsmDispatch.setBsm(bsm);

				pdrcBsmDispatchList.add(pdrcBsmDispatch);
			}
		}

		Collections.sort(pdrcBsmDispatchList, new PdrcBsmDispatchComparator());

		return pdrcBsmDispatchList;
	}

	public static List<PdrcBsmDispatch> getPdrcBsmDispatchListBackup(String path, List<IsbgHumanMap> isbgHumanMapList) {
		List<PdrcBsmDispatch> pdrcBsmDispatchList = new ArrayList<PdrcBsmDispatch>();
		// List<IsbgHumanMap> isbgHumanMapList =
		// DataService.getIsbgHumanMapListInfo(path);
		Map<String, String> workIDBsmMap = DataService.getWorkIDBsmMap(path);
		PdrcBsmDispatch pdrcBsmDispatch = null;
		for (IsbgHumanMap isbgHumanMap : isbgHumanMapList) {
			String staffWorkID = isbgHumanMap.getStaffWorkID();
			String projectID = isbgHumanMap.getProjectID();
			String inProDate = isbgHumanMap.getInProDate();
			String predictOutProDate = isbgHumanMap.getPredictOutProDate();

			String bsmState = Constants.BSM_STATE_DEFAULT;
			String bsm = "0";

			List<String> dateList = DateUtil.getMonthBetween(inProDate, predictOutProDate);
			for (String monthStr : dateList) {
				pdrcBsmDispatch = new PdrcBsmDispatch();

				pdrcBsmDispatch.setProjectID(projectID);
				pdrcBsmDispatch.setStaffWorkID(staffWorkID);

				String dispatchMonth = monthStr;
				String confrimTime = "NULL";

				if (DateUtil.beforeToday(predictOutProDate)) {
					confrimTime = predictOutProDate;

					// 已评价
					bsmState = Constants.BSM_STATE_CONFIRM;

					int randomNumber = MathUtil.getRandomByRange(Constants.BSM_RATE_MIN, Constants.BSM_RATE_MAX);
					double dRandomNumber = randomNumber * 0.1;
					String baseBsm = workIDBsmMap.get(staffWorkID);

					Double dBsm = dRandomNumber * Double.parseDouble(baseBsm);

					if ("0.0".equals(dBsm.toString())) {
						System.out.println("#####");
					}

					bsm = MathUtil.setScale(dBsm, 2).toString();
				}

				pdrcBsmDispatch.setDispatchMonth(dispatchMonth);
				pdrcBsmDispatch.setConfrimTime(confrimTime);
				pdrcBsmDispatch.setBsmState(bsmState);
				pdrcBsmDispatch.setBsm(bsm);

				pdrcBsmDispatchList.add(pdrcBsmDispatch);
			}
		}

		Collections.sort(pdrcBsmDispatchList, new PdrcBsmDispatchComparator());

		return pdrcBsmDispatchList;
	}

	public static List<PdrcEnpPrize> getPdrcEnpPrizeList(String path, List<IsbgHumanMap> isbgHumanMapList) {
		List<PdrcEnpPrize> pdrcEnpPrizeList = new ArrayList<PdrcEnpPrize>();
		List<PdrcBsmDispatch> pdrcBsmDispatchList = DataService.getPdrcBsmDispatchList(path, isbgHumanMapList);
		Map<String, List<String>> bsmMap = new HashMap<String, List<String>>();
		List<String> bsmList = null;
		for (PdrcBsmDispatch pdrcBsmDispatch : pdrcBsmDispatchList) {
			String staffWorkID = pdrcBsmDispatch.getStaffWorkID();
			String dispatchMonth = pdrcBsmDispatch.getDispatchMonth();
			String bsmState = pdrcBsmDispatch.getBsmState();
			String bsm = pdrcBsmDispatch.getBsm();
			String key = staffWorkID + ":" + dispatchMonth;

			if ("B-10097".equals(staffWorkID)) {
				System.out.println(pdrcBsmDispatch.getDispatchMonth() + "\t" + pdrcBsmDispatch.getBsm());
			}

			bsmList = bsmMap.get(key);
			if (null == bsmList || 1 > bsmList.size()) {
				bsmList = new ArrayList<>();
			}
			if (!"1".equals(bsmState)) {
				bsmList.add(bsm);
				bsmMap.put(key, bsmList);
			}
		}

		Map<String, String> workIDBsmMap = DataService.getWorkIDBsmMap(path);
		PdrcEnpPrize pdrcEnpPrize = null;
		for (String key : bsmMap.keySet()) {
			if ("B-10097:2017-02-01".equals(key)) {
				System.out.println("EEE");
			}
			pdrcEnpPrize = new PdrcEnpPrize();
			List<String> tempBsmList = bsmMap.get(key);

			String[] arr = key.split(":");
			pdrcEnpPrize.setWorkID(arr[0]);
			pdrcEnpPrize.setMonthDate(arr[1]);
			Double p = MathUtil.setScale(MathUtil.sumNumberList(tempBsmList), 2);
			String origBsm = workIDBsmMap.get(arr[0]);
			p -= Double.parseDouble(origBsm);

			if (0 < p) {
				p *= Constants.PDRD_BONUS;
				DecimalFormat df = new DecimalFormat("#"); // TODO
				pdrcEnpPrize.setPrize(df.format(p));
				pdrcEnpPrizeList.add(pdrcEnpPrize);
			}
		}

		Collections.sort(pdrcEnpPrizeList, new PdrcEnpPrizeComparator());
		return pdrcEnpPrizeList;
	}

}
