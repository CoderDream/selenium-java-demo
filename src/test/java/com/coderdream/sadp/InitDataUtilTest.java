package com.coderdream.sadp;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class InitDataUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInitDateMap() throws IOException {
		String fileFolder = this.getClass().getResource("/").getPath();
		String dataFileName = "PDRC_Data_Init.xlsx";
		String path = fileFolder + dataFileName;
		String sheetName = "Total2";
		Map<String, Set<String>> map = InitDataUtil.getInitDateMap(path,
						sheetName);

		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
			String roleName = entry.getKey();
			Set<String> workIdSet = map.get(roleName);
			for (String workId : workIdSet) {
				System.out.println(roleName + "\t" + workId);
			}
		}
	}

	@Test
	public void testUpdateDB() throws Exception {
		String fileFolder = this.getClass().getResource("/").getPath();
		String dataFileName = "PDRC_Data_Init.xlsx";
		String path = fileFolder + dataFileName;
		String sheetName = "Total2";
		Map<String, Set<String>> map = InitDataUtil.getInitDateMap(path,
						sheetName);

		InitDataUtil.updateDB(map);
	}

}
