package com.coderdream.gensql.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.gensql.bean.IsbgHumanMap;
import com.coderdream.gensql.bean.IsbgProject;
import com.coderdream.gensql.bean.MemberParticipate;
import com.coderdream.gensql.bean.Menu;
import com.coderdream.gensql.bean.PdrcBsmDispatch;
import com.coderdream.gensql.bean.PdrcEnpPrize;
import com.coderdream.gensql.bean.PdrcStaffManage;
import com.coderdream.gensql.bean.PdrcTm;
import com.coderdream.gensql.bean.PdrcTmSalary;
import com.coderdream.gensql.bean.PmTmRelation;
import com.coderdream.gensql.bean.Role;
import com.coderdream.util.Constants;

public class DataServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(DataServiceTest.class);

	private String fileFolder;

	private String dataFileName;

	@Before
	public void setUp() throws Exception {
		fileFolder = getClass().getResource("../../../../").getFile().toString();
		dataFileName = Constants.DATA_FILE_NAME;
	}

	@Test
	public void testGetPdrcTmList() {
		String path = fileFolder + dataFileName;
		DataService dataService = new DataService();
		List<PdrcTm> list = dataService.getPdrcTmList(path);
		for (PdrcTm pdrcTm : list) {
			System.out.println(pdrcTm);
			logger.debug(pdrcTm.toString());
		}
	}

	@Test
	public void testGetPdrcStaffManageList() {
		String path = fileFolder + dataFileName;
		DataService dataService = new DataService();
		List<PdrcStaffManage> list = dataService.getPdrcStaffManageList(path);
		for (PdrcStaffManage pdrcStaffManage : list) {
			System.out.println(pdrcStaffManage);
		}
	}
	
	@Test
	public void testGetPdrcStaffManageList_02() {
		String path = fileFolder + "Data_20170531.xlsx";
		String sheetName = "RC"; // TODO
		DataService dataService = new DataService();
		List<PdrcStaffManage> drcStaffManageList = dataService.getPdrcStaffManageList(path, sheetName);
		System.out.println(drcStaffManageList.size());
		for (PdrcStaffManage pdrcStaffManage : drcStaffManageList) {
			System.out.println(pdrcStaffManage);
		}
	}	
	
	@Test
	public void testGetRoleList_01() {
		String path = fileFolder + "Data_20170531.xlsx";
		String sheetName = "Role"; // TODO
		List<Role> roleList = DataService.getRoleList(path, sheetName);
		System.out.println(roleList.size());
		for (Role role : roleList) {
			System.out.println(role);
		}
	}
	
	@Test
	public void testGetMenuList_01() {
		String path = fileFolder + "Data_20170531.xlsx";
		String sheetName = "Menu"; // TODO
		List<Menu> menuList = DataService.getMenuList(path, sheetName);
		System.out.println(menuList.size());
		for (Menu menu : menuList) {
			System.out.println(menu);
		}
	}
	
	
	@Test
	public void testGetWorkIdMenuNameMap_01() {
		String path = fileFolder + "Data_20170531.xlsx";
		String sheetName1 = "Role"; 
		List<Role> roleList = DataService.getRoleList(path, sheetName1);
		
		String sheetName2 = "Menu"; 
		List<Menu> menuList = DataService.getMenuList(path, sheetName2);
		System.out.println(menuList.size());
		
		Map<String, List<String>> menuNameListMap = DataService.getWorkIdMenuNameMap(roleList, menuList);
		
		for (String key : menuNameListMap.keySet()) {
			List<String> menuNameList = menuNameListMap.get(key);
			for (String menuName : menuNameList) {
				System.out.println(key + "\t\t" + menuName);
			}
		}
	}
	
	
	@Test
	public void testGetIsbgProjectList() {
		String path = fileFolder + dataFileName;
		List<IsbgProject> list = DataService.getIsbgProjectList(path);
		for (IsbgProject isbgProject : list) {
			System.out.println(isbgProject);
		}
	}

	@Test
	public void testGetPdrcStaffManageListMap() {
		String path = fileFolder + dataFileName;
		Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap = DataService.getPdrcStaffManageListMap(path);

		for (String key : pdrcStaffManageListMap.keySet()) {
			List<PdrcStaffManage> pdrcStaffManageList = pdrcStaffManageListMap.get(key);
			System.out.println("TM WorkId\t" + key);
			for (PdrcStaffManage pdrcStaffManage : pdrcStaffManageList) {
				System.out.println("WorkId\t\t" + pdrcStaffManage.getWorkID());
			}
		}
	}
	
	
	@Test
	public void testGetMemberParticipateMap() { // TODO
		String path = fileFolder + dataFileName;
		List<IsbgProject> totalIsbgProjectList = DataService.getIsbgProjectListInfo(path);
		Map<String, IsbgProject> isbgProjectMap = DataService.getIsbgProjectMap(totalIsbgProjectList);
		List<IsbgHumanMap> isbgHumanMapList = DataService.getIsbgHumanMapListInfo(path, isbgProjectMap);
		Map<String, Double> memberParticipateMap = DataService.getMemberParticipateMap(isbgHumanMapList);
		for (String key : memberParticipateMap.keySet()) {
			Double memberParticipateValue = memberParticipateMap.get(key);
			System.out.println(key + "\t" + memberParticipateValue);
		}
	}
		

	@Test
	public void testGetMemberParticipateList() {
		String path = fileFolder + dataFileName;
		List<IsbgProject> totalIsbgProjectList = DataService.getIsbgProjectListInfo(path);
		Map<String, IsbgProject> isbgProjectMap = DataService.getIsbgProjectMap(totalIsbgProjectList);
		List<IsbgHumanMap> isbgHumanMapList = DataService.getIsbgHumanMapListInfo(path, isbgProjectMap);
		List<MemberParticipate> memberParticipateList = DataService.getMemberParticipateList(isbgHumanMapList);
		System.out.println("size: \t" + memberParticipateList.size());
		for (MemberParticipate memberParticipate : memberParticipateList) {
			System.out.println(memberParticipate.getProjectID() + "\t" + memberParticipate.getStaffWorkID() + "\t"
					+ memberParticipate.getMonthDate() + "\t"
							+ memberParticipate.getParticipateRate());
		}
	}

	@Test
	public void testGetBsmSumByTmWorkId() {
		String path = fileFolder + dataFileName;
		String tmWorkId = "B-13454";
		Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap = DataService.getPdrcStaffManageListMap(path);
		Double result = DataService.getBsmSumByTmWorkId(pdrcStaffManageListMap, tmWorkId);
		Double expectValue = new Double(10.4);
		assertEquals(expectValue, result);
	}

	@Test
	public void testGetPdrcTmSalaryList() {
		String path = fileFolder + dataFileName;
		Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap = DataService.getPdrcStaffManageListMap(path);
		List<PdrcTmSalary> pdrcTmSalaryList = DataService.getPdrcTmSalaryList(pdrcStaffManageListMap);
		for (PdrcTmSalary pdrcTmSalary : pdrcTmSalaryList) {
			System.out.println(pdrcTmSalary);
		}
	}

	@Test
	public void testGetPdrcTmSalaryListWithDateRange() {
		String path = fileFolder + dataFileName;
		String startDateString = "2016-01-01";
		String endDateString = "2017-12-31";
		Map<String, List<PdrcStaffManage>> pdrcStaffManageListMap = DataService.getPdrcStaffManageListMap(path);
		List<PdrcTmSalary> pdrcTmSalaryList = DataService.getPdrcTmSalaryListWithDateRange(pdrcStaffManageListMap,
				startDateString, endDateString);
		System.out.println("########### size:  " + pdrcTmSalaryList.size());
		for (PdrcTmSalary pdrcTmSalary : pdrcTmSalaryList) {
			System.out.println(pdrcTmSalary);
		}
	}

	@Test
	public void testGetPmTmRelationList() {
		String path = fileFolder + dataFileName;

		List<PmTmRelation> pmRmRelationList = DataService.getPmTmRelationList(path);

		for (PmTmRelation pmRmRelation : pmRmRelationList) {
			String pmWorkID = pmRmRelation.getPmWorkID();
			String tmWorkID = pmRmRelation.getTmWorkID();
			System.out.println(pmWorkID + "\t" + tmWorkID);
			// List<String> workIDList = pmRmRelation.getWorkIDList();
			// for (String workID : workIDList) {
			// System.out.println(pmWorkID + "\t" + tmWorkID + "\t" + workID);
			// }
		}
	}

	@Test
	public void testGetTmWorkIDByPmWorkID() {
		String path = fileFolder + dataFileName;
		String pmWorkIDParam = "B-14444";
		String tmWorkID = DataService.getTmWorkIDByPmWorkID(path, pmWorkIDParam);
		String expectValue = "B-13454";
		assertEquals(expectValue, tmWorkID);
	}

	@Test
	public void testGetIsbgProjectListMap() {
		String path = fileFolder + dataFileName;
		Map<String, List<IsbgProject>> isbgProjectListMap = DataService.getIsbgProjectListMap(path);

		for (String key : isbgProjectListMap.keySet()) {

			List<IsbgProject> isbgProjectList = isbgProjectListMap.get(key);

			System.out.println("projectMgrWorkID\t" + key);
			for (IsbgProject isbgProject : isbgProjectList) {
				// System.out.println("WorkId\t\t" + isbgProject);
				System.out.println(isbgProject);
			}

		}
	}

	@Test
	public void testGetPmWorkIDTmWorkIDMap() {
		String path = fileFolder + dataFileName;
		Map<String, String> pmWorkIDTmWorkIDMap = DataService.getPmWorkIDTmWorkIDMap(path);

		for (String pmWorkID : pmWorkIDTmWorkIDMap.keySet()) {
			String tmWorkID = pmWorkIDTmWorkIDMap.get(pmWorkID);
			System.out.println(pmWorkID + "\t" + tmWorkID);
		}
	}

	@Test
	public void testGetPmWorkIDListMap() {
		String path = fileFolder + dataFileName;
		Map<String, List<String>> pmWorkIDListMap = DataService.getPmWorkIDListMap(path);

		for (String key : pmWorkIDListMap.keySet()) {
			List<String> workIDList = pmWorkIDListMap.get(key);
			for (String workID : workIDList) {
				System.out.println(key + "\t" + workID);
			}
		}
	}

//	@Test
//	public void testGetIsbgHumanMapList() {
//		String path = fileFolder + dataFileName;
//		List<IsbgHumanMap> isbgHumanMapList = DataService.getIsbgHumanMapList(path);
//		for (IsbgHumanMap isbgHumanMap : isbgHumanMapList) {
//			System.out.println(isbgHumanMap);
//		}
//	}

	@Test
	public void testGetIsbgHumanMapListInfo() {
		String path = fileFolder + dataFileName;
//		List<IsbgHumanMap> isbgHumanMapList
		List<IsbgProject> totalIsbgProjectList = DataService.getIsbgProjectListInfo(path);
		Map<String, IsbgProject> isbgProjectMap = DataService.getIsbgProjectMap(totalIsbgProjectList);
		List<IsbgHumanMap> isbgHumanMapList = DataService.getIsbgHumanMapListInfo(path, isbgProjectMap);
		System.out.println(isbgHumanMapList.size());
		for (IsbgHumanMap isbgHumanMap : isbgHumanMapList) {
			System.out.println(isbgHumanMap);
		}
	}

	@Test
	public void testGetIsbgProjectListInfo() {
		String path = fileFolder + dataFileName; // TODO
		List<IsbgProject> totalIsbgProjectList = DataService.getIsbgProjectListInfo(path);
		for (IsbgProject isbgProject : totalIsbgProjectList) {
			 System.out.println(isbgProject);
//			System.out.println(isbgProject.getProjectStartDateTime() + "\t" + isbgProject.getProjectEndDateTime() + "\t"
//					+ isbgProject.getPdrc());
		}
	}

	@Test
	public void testGetIsbgProjectMap() {
		String path = fileFolder + dataFileName;
		List<IsbgProject> totalIsbgProjectList = DataService.getIsbgProjectListInfo(path);
		Map<String, IsbgProject> isbgProjectMap = DataService.getIsbgProjectMap(totalIsbgProjectList);

		for (String key : isbgProjectMap.keySet()) {
			IsbgProject isbgProject = isbgProjectMap.get(key);
			System.out.println(isbgProject);
		}
	}

	@Test
	public void testGetWorkingDaysMap() {
		String path = fileFolder + dataFileName;
		List<IsbgProject> totalIsbgProjectList = DataService.getIsbgProjectListInfo(path);
		Map<String, IsbgProject> isbgProjectMap = DataService.getIsbgProjectMap(totalIsbgProjectList);
		Map<String, Integer> workIdDaysMap = DataService.getWorkingDaysMap(path, isbgProjectMap);

		for (String key : workIdDaysMap.keySet()) {
			Integer value = workIdDaysMap.get(key);
			System.out.println(key + "\t" + value);
			if (731 != value) {
				System.out.println("####   " + key);
			}
		}
	}

	@Test
	public void testGetWorkIDBsmMap() {
		String path = fileFolder + dataFileName;
		Map<String, String> workIDBsmMap = DataService.getWorkIDBsmMap(path);

		for (String key : workIDBsmMap.keySet()) {
			String isbgProject = workIDBsmMap.get(key);
			System.out.println(key + "\t" + isbgProject);
		}
	}

	@Test
	public void testGetPdrcBsmDispatchList() {
		String path = fileFolder + dataFileName;
		
		List<IsbgProject> totalIsbgProjectList = DataService.getIsbgProjectListInfo(path);
		Map<String, IsbgProject> isbgProjectMap = DataService.getIsbgProjectMap(totalIsbgProjectList);
		List<IsbgHumanMap> isbgHumanMapList = DataService.getIsbgHumanMapListInfo(path, isbgProjectMap);
		List<PdrcBsmDispatch> pdrcBsmDispatchList = DataService.getPdrcBsmDispatchList(path, isbgHumanMapList);
		System.out.println("size: \t" + pdrcBsmDispatchList.size());
		for (PdrcBsmDispatch pdrcBsmDispatch : pdrcBsmDispatchList) {
			System.out.println(pdrcBsmDispatch);
		}
	}

	@Test
	public void testGetPdrcEnpPrizeList() {
		String path = fileFolder + dataFileName;
		List<IsbgProject> totalIsbgProjectList = DataService.getIsbgProjectListInfo(path);
		Map<String, IsbgProject> isbgProjectMap = DataService.getIsbgProjectMap(totalIsbgProjectList);
		List<IsbgHumanMap> isbgHumanMapList = DataService.getIsbgHumanMapListInfo(path, isbgProjectMap);
		List<PdrcEnpPrize> pdrcEnpPrizeList = DataService.getPdrcEnpPrizeList(path, isbgHumanMapList);
		for (PdrcEnpPrize pdrcEnpPrize : pdrcEnpPrizeList) {
			System.out.println(pdrcEnpPrize);
		}
	}

}
