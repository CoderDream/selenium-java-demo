package com.coderdream.util;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ExcelUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadExcel() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadXlsx() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAllData() throws IOException {
		String fileFolder = this.getClass().getResource("/").getPath();
		String dataFileName = "PDRC_Data_Init.xlsx";
		String path = fileFolder + dataFileName;
		String sheetName = "Total2";
		List<String[]> arrayList = ExcelUtil.readAllData(path, sheetName);
		for (String[] strings : arrayList) {
			for (String string : strings) {
				System.out.println(string);
			}
		}
	}

	@Test
	public void testReadAllData_02() throws IOException {
		String fileFolder = this.getClass().getResource("/").getPath();
		String dataFileName = "PDRC_Data_Init.xlsx";
		String path = fileFolder + dataFileName;
		String sheetName = "Total2";
		Map<String, Set<String>> map = getInitDateMap(path, sheetName);

		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
			String roleName = entry.getKey();
			Set<String> workIdSet = map.get(roleName);
			for (String workId : workIdSet) {
				System.out.println(roleName + "\t" + workId);
			}
		}
	}

	private Map<String, Set<String>> getInitDateMap(String path,
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

	@Test
	public void testReadData() throws IOException {
		String fileFolder = this.getClass().getResource("/").getPath();
		String dataFileName = "PDRC_Data_Init.xlsx";
		String path = fileFolder + dataFileName;
		String sheetName = "Total2";
		List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
		for (String[] strings : arrayList) {
			for (String string : strings) {
				System.out.println(string);
			}
		}
	}

	@Test
	public void testReadXls() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPostfix() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadingAndRewritingIsbgProjectInfo() {
		fail("Not yet implemented");
	}

}
