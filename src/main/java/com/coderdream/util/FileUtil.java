package com.coderdream.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static void main(String[] args) {
		method05();
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
				String sql = stringBuffer.toString() + ind + ", N'MajorInfo', N'M"
						+ String.format("%04d", ind - 5) + "', N'" + string + "', 6, '');";
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
				String sql = stringBuffer.toString() + ind + ", N'UniversityInfo', N'U"
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
				String sql = stringBuffer.toString() + ind + ", N'EducationInfo', N'E"
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

		StringBuffer stringBuffer = new StringBuffer(
				"INSERT INTO [PDRC_Dictionary]	([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES (");
		String strParent = stringBuffer.toString()
				+ "3570, N'EmployeeStateInfo', 'EmployeeState', 'EmployeeState', null, null );";
		System.out.println(strParent);
		int ind = 3571;
		for (String string : major) {
			String sql = stringBuffer.toString() + ind + ", N'EmployeeStateInfo', N'E"
					+ String.format("%04d", ind - 5) + "', N'" + string + "', 3570, '');";
			System.out.println(sql);
			ind++;
			// System.out.println(String.format("%04d", ind));
		}
	}

	public static void method05() {
		List<String> major = new ArrayList<String>();
		major.add("武汉");
		major.add("深圳");
		major.add("东莞");
		major.add("成都");
		major.add("广州");
		major.add("上海");
		major.add("大连");
		major.add("重庆");
		int index = 3574;
		StringBuffer stringBuffer = new StringBuffer(
				"INSERT INTO [PDRC_Dictionary] ([ID],[Type],[KeyName],[value],[ParentID],[Remark])VALUES (");
		String strParent = stringBuffer.toString() + index
				+ ", N'CandidateCityInfo', 'CandidateCity', 'CandidateCity', null, null );";
		System.out.println(strParent);
		int ind = index + 1;
		for (String string : major) {
			String sql = stringBuffer.toString() + ind
					+ ", N'CandidateCityInfo', N'CC" + String.format("%02d", ind - index)
					+ "', N'" + string + "', " + index + ", '');";
			System.out.println(sql);
			ind++;
			// System.out.println(String.format("%04d", ind));
		}
	}

}