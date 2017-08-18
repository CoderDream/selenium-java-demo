package com.coderdream.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {

	public static void main(String[] args) {
		method10();
		method11();
		method12();
	}

	public static void method00() {
		// List<String> major = new ArrayList<String>();

		// value ParentID Remark
		// 1 参与过相关领域1到2个小型项目，非主导角色，大体了解一些领域里关键概念
		// 部分精通 1 在领域内的局部有5000小时以上工作经历，对局部概念、流程相当熟悉
		// 领域专家 1 对领域内的全局到局部有充分的掌握，10000小时以上工作经历
		// String str = "ERP:CRM:PLM:FIN:HR";
		// String[] strArray = str.split(":");
		// int len = strArray.length;
		// for (int i = 0; i < len; i++) {
		// String string = strArray[i];
		// major.add(string);
		// }

		String name = "ExperienceLevel";

		int index = 1;
		StringBuffer stringBuffer = new StringBuffer(
				"INSERT INTO [PDRC_Dictionary] ([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES (");
		String strParent = stringBuffer.toString() + index + ", N'" + name
				+ "Info', '" + name + "',N'" + name + "', null, null );";
		System.out.println(strParent);
		int ind = index + 1;
		Map<String, String> map = new HashMap<String, String>();
		map.put("轻度接触", "参与过相关领域1到2个小型项目，非主导角色，大体了解一些领域里关键概念");
		map.put("部分精通", "在领域内的局部有5000小时以上工作经历，对局部概念、流程相当熟悉 ");
		map.put("领域专家", "对领域内的全局到局部有充分的掌握，10000小时以上工作经历");

		for (Map.Entry<String, String> entry : map.entrySet()) {

			// System.out.println("Key = " + entry.getKey() + ", Value = " +
			// entry.getValue());

			String sql = stringBuffer.toString() + ind + ", N'" + name
					+ "Info', N'EL" + String.format("%02d", ind - index)
					+ "', N'" + entry.getKey() + "', " + index + ", '"
					+ entry.getValue() + "');";
			System.out.println(sql);
			ind++;
		}

		// System.out.println(String.format("%04d", ind));
	}

	public static void method01() {
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader("d://master02.txt");
			BufferedReader br = new BufferedReader(reader);

			String str = null;
			List<String> major = new ArrayList<String>();

			int index = 0;
			while ((str = br.readLine()) != null) {
				sb.append(str + "/n");
				if (null != str && !"".equals(str.trim())) {
					index++;
					// System.out.println(index);
					if (index % 2 == 0) {
						String[] strArray = str.split("、");
						int len = strArray.length;
						for (int i = 0; i < len; i++) {
							String string = strArray[i];
							major.add(string);
						}

						// System.out.println(str);
					}
				}
			}

			// INSERT INTO [PDRC_Dictionary]
			// ([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES
			// (<ID, int,>
			// ,<Type, nvarchar(50),>
			// ,<KeyName, nvarchar(50),>
			// ,<value, nvarchar(50),>
			// ,<ParentID, int,>
			// ,<Remark, nvarchar(100),>);

			StringBuffer stringBuffer = new StringBuffer(
					"INSERT INTO [PDRC_Dictionary]	([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES (");
			String strParent = stringBuffer.toString()
					+ "5, N'MajorInfo', 'Major', '', null, null );";
			System.out.println(strParent);
			// System.out.println("size:\t" + major.size());
			int ind = 6;
			for (String string : major) {
				String sql = stringBuffer.toString() + ind
						+ ", N'MajorInfo', N'M" + String.format("%04d", ind - 5)
						+ "', N'" + string + "', 6, '');";
				System.out.println(sql);
				ind++;
				// System.out.println(String.format("%04d", ind));
			}

			br.close();
			reader.close();

			// write string to file
			// FileWriter writer = new FileWriter("c://test2.txt");
			// BufferedWriter bw = new BufferedWriter(writer);
			// bw.write(sb.toString());
			//
			// bw.close();
			// writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void method02() {
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader("d://u01.txt");
			BufferedReader br = new BufferedReader(reader);

			String str = null;
			List<String> major = new ArrayList<String>();

			int index = 0;
			while ((str = br.readLine()) != null) {
				sb.append(str + "/n");
				if (null != str && !"".equals(str.trim())) {
					index++;
					// System.out.println(index);
					String[] strArray = str.split("、");
					int len = strArray.length;
					for (int i = 0; i < len; i++) {
						String string = strArray[i];
						major.add(string);
					}

					// System.out.println(str);
				}
			}

			System.out.println(index);
			// INSERT INTO [PDRC_Dictionary]
			// ([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES
			// (<ID, int,>
			// ,<Type, nvarchar(50),>
			// ,<KeyName, nvarchar(50),>
			// ,<value, nvarchar(50),>
			// ,<ParentID, int,>
			// ,<Remark, nvarchar(100),>);

			StringBuffer stringBuffer = new StringBuffer(
					"INSERT INTO [PDRC_Dictionary]	([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES (");
			String strParent = stringBuffer.toString()
					+ "1136, N'UniversityInfo', 'University', 'University', null, null );";
			System.out.println(strParent);
			// System.out.println("size:\t" + major.size());
			int ind = 1137;
			for (String string : major) {
				String sql = stringBuffer.toString() + ind
						+ ", N'UniversityInfo', N'U"
						+ String.format("%04d", ind - 5) + "', N'" + string
						+ "', 1136, '');";
				System.out.println(sql);
				ind++;
				// System.out.println(String.format("%04d", ind));
			}

			br.close();
			reader.close();

			// write string to file
			// FileWriter writer = new FileWriter("c://test2.txt");
			// BufferedWriter bw = new BufferedWriter(writer);
			// bw.write(sb.toString());
			//
			// bw.close();
			// writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void method03() {
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader("d://e01.txt");
			BufferedReader br = new BufferedReader(reader);

			String str = null;
			List<String> major = new ArrayList<String>();

			int index = 0;
			while ((str = br.readLine()) != null) {
				sb.append(str + "/n");
				if (null != str && !"".equals(str.trim())) {
					index++;
					// System.out.println(index);
					String[] strArray = str.split("、");
					int len = strArray.length;
					for (int i = 0; i < len; i++) {
						String string = strArray[i];
						major.add(string);
					}
					// System.out.println(str);
				}
			}
			System.out.println(index);
			// INSERT INTO [PDRC_Dictionary]
			// ([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES
			// (<ID, int,>
			// ,<Type, nvarchar(50),>
			// ,<KeyName, nvarchar(50),>
			// ,<value, nvarchar(50),>
			// ,<ParentID, int,>
			// ,<Remark, nvarchar(100),>);

			StringBuffer stringBuffer = new StringBuffer(
					"INSERT INTO [PDRC_Dictionary]	([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES (");
			String strParent = stringBuffer.toString()
					+ "3565, N'EducationInfo', 'Education', 'Education', null, null );";
			System.out.println(strParent);
			// System.out.println("size:\t" + major.size());
			int ind = 3566;
			for (String string : major) {
				String sql = stringBuffer.toString() + ind
						+ ", N'EducationInfo', N'E"
						+ String.format("%04d", ind - 5) + "', N'" + string
						+ "', 3565, '');";
				System.out.println(sql);
				ind++;
				// System.out.println(String.format("%04d", ind));
			}

			br.close();
			reader.close();

			// write string to file
			// FileWriter writer = new FileWriter("c://test2.txt");
			// BufferedWriter bw = new BufferedWriter(writer);
			// bw.write(sb.toString());
			//
			// bw.close();
			// writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void method04() {
		List<String> major = new ArrayList<String>();
		major.add("在项");
		major.add("离项");
		major.add("离职");

		String name = "EmployeeState";
		String prefix = "CC";
		int index = 3570;
		genSql(major, name, name, prefix, index);
	}

	public static void method05() {
		List<String> major = new ArrayList<String>();
		major.add("不限");
		major.add("武汉");
		major.add("深圳");
		major.add("东莞");
		major.add("成都");
		major.add("广州");
		major.add("上海");
		major.add("大连");
		int index = 3574;
		String name = "CandidateCity";
		String prefix = "CC";
		genSql(major, name, name, prefix, index);
	}

	public static void method06() {
		List<String> major = new ArrayList<String>();
		String str = "JAVA:DOTNET:BI:DBA:H5:ANDROID:iOS:大数据（Hadoop、Spark等）:云计算（OpenStack、Azue等）:微服务:功能测试:性能测试:自动化测试:配置管理:敏捷开发:DevOps:ITIL";
		String[] strArray = str.split(":");
		int len = strArray.length;
		for (int i = 0; i < len; i++) {
			String string = strArray[i];
			major.add(string);
		}

		int index = 3583;
		String name = "Skill";
		String prefix = "S";
		genSql(major, name, name, prefix, index);
	}

	public static void method07() {
		List<String> major = new ArrayList<String>();
		String str = "ERP:CRM:PLM:FIN:HR";
		String[] strArray = str.split(":");
		int len = strArray.length;
		for (int i = 0; i < len; i++) {
			String string = strArray[i];
			major.add(string);
		}

		String name = "Domain";
		int index = 3601;
		String prefix = "D";
		genSql(major, name, name, prefix, index);
	}

	// 开启/结束
	public static void method08() {
		List<String> major = new ArrayList<String>();
		String str = "开启:结束";
		String[] strArray = str.split(":");
		int len = strArray.length;
		for (int i = 0; i < len; i++) {
			String string = strArray[i];
			major.add(string);
		}

		String name = "TaskState";
		int index = 3607;
		String prefix = "TS";
		genSql(major, name, name, prefix, index);
	}

	private static void genSql(List<String> major, String name, String value,
			String prefix, int index) {
		StringBuffer stringBuffer = new StringBuffer(
				"INSERT INTO [DataDict] ([ID],[Type],[KeyName],[value],[ParentID],[Remark],[SortIndex])VALUES (");
		String strParent = stringBuffer.toString() + index + ", N'" + name
				+ "Info', '" + value + "',N'" + name + "', null, null, null );";
		System.out.println(strParent);
		int ind = index + 1;
		for (String string : major) {
			String sql = stringBuffer.toString() + ind + ", N'" + name
					+ "Info', N'" + prefix + String.format("%02d", ind - index)
					+ "', N'" + string + "', " + index + ", " + (ind - index)
					+ ",'');";
			System.out.println(sql);
			ind++;
			// System.out.println(String.format("%04d", ind));
		}
	}

	// 了解:掌握:熟练:精通
	public static void method09() {
		List<String> items = new ArrayList<String>();
		String str = "了解:掌握:熟练:精通";
		String[] strArray = str.split(":");
		int len = strArray.length;
		for (int i = 0; i < len; i++) {
			String string = strArray[i];
			items.add(string);
		}

		String name = "Proficiency";
		int index = 3610;
		String prefix = "P";
		genSql(items, name, name, prefix, index);
	}

	/**
	 * 目标合理性
	 */
	public static void method10() {
		List<String> items = new ArrayList<String>();
		items.add("质量目标合理性");
		items.add("计划收入计划成本合理性");
		items.add("变更修正合理性");

		String name = "ReasonableObjective";
		String value = "目标合理性";
		int index = 1;
		String prefix = "RO";
		genSql(items, name, value, prefix, index);
	}

	// 了解:掌握:熟练:精通
	/**
	 * 操作规范性
	 */
	public static void method11() {
		List<String> items = new ArrayList<String>();
		items.add("立项结项及时性");
		items.add("主项目子项目挂接正确性");
		items.add("人力挂接项目（含IDLE）正确性");
		items.add("项目评价合理性");

		String name = "OperationStandard";
		String value = "操作规范性";
		int index = 5;
		String prefix = "OS";
		genSql(items, name, value, prefix, index);
	}

	// 了解:掌握:熟练:精通
	/**
	 * 数据准确性
	 */
	public static void method12() {
		List<String> items = new ArrayList<String>();
		items.add("质量评价数据填报准确性");
		items.add("人力地图数据准确性");

		String name = "AccurateData";
		String value = "数据准确性";
		int index = 11;
		String prefix = "AD";
		genSql(items, name, value, prefix, index);
	}
}