package com.coderdream.readfolder.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.readfolder.bean.FileInfo;

public class ReadDirectory {

	private static final Logger logger = LoggerFactory.getLogger(ReadDirectory.class);
	// 文件所在的层数
	private int fileLevel;

	/**
	 * 生成输出格式
	 * 
	 * @param name
	 *            输出的文件名或目录名
	 * @param level
	 *            输出的文件名或者目录名所在的层次
	 * @return 输出的字符串
	 */
	public String createPrintStr(String name, int level) {
		// 输出的前缀
		String printStr = "";
		// 按层次进行缩进
		for (int i = 0; i < level; i++) {
			printStr = printStr + " ";
		}
		printStr = printStr + "- " + name;
		return printStr;
	}

	/**
	 * 输出初始给定的目录
	 * 
	 * @param dirPath
	 *            给定的目录
	 */
	public void printDir(String dirPath) {
		// 将给定的目录进行分割
		String[] dirNameList = dirPath.split("\\\\");
		// 设定文件level的base
		fileLevel = dirNameList.length;
		// 按格式输出
		for (int i = 0; i < dirNameList.length; i++) {
			System.out.println(createPrintStr(dirNameList[i], i));
		}
	}

	/**
	 * 输出给定目录下的文件，包括子目录中的文件
	 * 
	 * @param dirPath
	 *            给定的目录
	 */
	public void readFile(String dirPath) {
		// 建立当前目录中文件的File对象
		File file = new File(dirPath);
		// 取得代表目录中所有文件的File对象数组
		File[] list = file.listFiles();
		// 遍历file数组
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				System.out.println(createPrintStr(list[i].getName(), fileLevel));
				fileLevel++;
				// 递归子目录
				readFile(list[i].getPath());
				fileLevel--;
			} else {
				File tempFile = list[i];
				if (tempFile.exists() && tempFile.isFile()) {
					// logger.info("" + tempFile.length());
				} else {
					logger.info("file doesn't exist or is not a file");
				}
				System.out.println(createPrintStr(tempFile.getName() + "\t" + tempFile.length(), fileLevel));
			}
		}
	}

	public void getFile(String path) {
		// get file list where the path has
		File file = new File(path);
		// get the folder list
		File[] array = file.listFiles();

		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				// only take file name
				System.out.println("^^^^^" + array[i].getName());
				// take file path and name
				System.out.println("#####" + array[i]);
				// take file path and name
				System.out.println("*****" + array[i].getPath());
			} else if (array[i].isDirectory()) {
				getFile(array[i].getPath());
			}
		}
	}

	public void getFilenameList(String path, List<String> filenameList) {
		long startTime = System.nanoTime(); // 获取开始时间
		// get file list where the path has
		File file = new File(path);
		// get the folder list
		File[] array = file.listFiles();

		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				// only take file name
				// System.out.println("^^^^^" + array[i].getName());
				// // take file path and name
				// System.out.println("#####" + array[i]);
				// // take file path and name
				// System.out.println("*****" + array[i].getPath());
				filenameList.add(array[i].getPath());
			} else if (array[i].isDirectory()) {
				getFilenameList(array[i].getPath(), filenameList);
			}
		}
		long endTime = System.nanoTime(); // 获取结束时间

		logger.debug("程序运行时间： " + (endTime - startTime) + "ns");
	}

	/**
	 * 
	 * Java获取指定文件夹下的所有文件名
	 * http://blog.csdn.net/tomorrowzm/article/details/3693653
	 * 
	 * @param path
	 * @param fileInfoMap
	 */
	public void getFile(String path, Map<String, FileInfo> fileInfoMap) {
		logger.info("getFile begin");
		logger.info("path： " + path);
		// get file list where the path has
		File file = new File(path);
		// get the folder list
		File[] array = file.listFiles();

		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				// only take file name
				// System.out.println("^^^^^" + array[i].getName());
				// // take file path and name
				// System.out.println("#####" + array[i]);
				// // take file path and name
				// System.out.println("*****" + array[i].getPath());
				FileInfo fileInfo = new FileInfo();
				fileInfo.setFilename(array[i].getPath());
				fileInfo.setFilesize("" + array[i].length());
				Calendar cal = Calendar.getInstance();
				long time = array[i].lastModified();
				cal.setTimeInMillis(time);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cal.setTimeInMillis(time);
				// System.out.println("修改时间[2] " +
				// formatter.format(cal.getTime()));
				// System.out.println(getFileCreated(array[i]));
				fileInfo.setCreateDateStr(getFileCreated(array[i]));
				fileInfo.setUpdateDateStr(formatter.format(cal.getTime()));
				fileInfo.setDeleteFlag("false");
				fileInfoMap.put(array[i].getPath(), fileInfo);
			} else if (array[i].isDirectory()) {
				getFile(array[i].getPath(), fileInfoMap);
			}
			logger.info("getFile end");
		}
	}

	/**
	 * Java中如何获取文件创建时间 http://blog.csdn.net/dancen/article/details/8715044
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileCreated(final File file) {
		if (null == file) {
			return null;
		}

		String rs = null;
		final StringBuilder sb = new StringBuilder();
		Process p = null;

		try {
			p = Runtime.getRuntime().exec(String.format("cmd /C dir %s /tc", file.getAbsolutePath()));
		} catch (IOException e) {
			return rs;
		}

		final InputStream is = p.getInputStream();
		final InputStreamReader ir = new InputStreamReader(is);
		final BufferedReader br = new BufferedReader(ir);

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				String data = null;

				try {
					while (null != (data = br.readLine())) {
						if (-1 != data.toLowerCase().indexOf(file.getName().toLowerCase())) {
							String[] temp = data.split(" +");

							if (2 <= temp.length) {
								String time = String.format("%s %s", temp[0], temp[1]);
								sb.append(time);
							}

							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (null != br) {
							br.close();
						}

						if (null != ir) {
							ir.close();
						}

						if (null != is) {
							is.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (0 != sb.length()) {
			rs = sb.toString();
		}

		return rs;
	}

	public List<FileInfo> makeFileInfoList(Collection<FileInfo> fileInfoValues) {
		logger.info("makeFileInfoList begin");
		List<FileInfo> fileInfoList = new ArrayList<>();
		for (FileInfo value : fileInfoValues) {
			System.out.println("Value = " + value);
			FileInfo fileInfo = new FileInfo();
			// 赋值
			try {
				BeanUtils.copyProperties(fileInfo, value);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}

			String filename = value.getFilename();
			String[] nameArray = filename.split("\\\\");
			int length = nameArray.length;
			switch (length) {
			case 0:
				break;
			case 1:
				fileInfo.setName(nameArray[0]);
				break;
			case 2:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setName(nameArray[1]);
				break;
			case 3:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setLevel2(nameArray[1]);
				fileInfo.setName(nameArray[2]);
				break;
			case 4:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setLevel2(nameArray[1]);
				fileInfo.setLevel3(nameArray[2]);
				fileInfo.setName(nameArray[3]);
				break;
			case 5:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setLevel2(nameArray[1]);
				fileInfo.setLevel3(nameArray[2]);
				fileInfo.setLevel4(nameArray[3]);
				fileInfo.setName(nameArray[4]);
				break;
			case 6:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setLevel2(nameArray[1]);
				fileInfo.setLevel3(nameArray[2]);
				fileInfo.setLevel4(nameArray[3]);
				fileInfo.setLevel5(nameArray[4]);
				fileInfo.setName(nameArray[5]);
				break;

			default:
				break;
			}

			fileInfoList.add(fileInfo);
		}
		logger.info("makeFileInfoList end");
		return fileInfoList;
	}

	public List<FileInfo> makeFileInfoFormFileList(List<String> fileList) {
		logger.info("makeFileInfoList begin");
		List<FileInfo> fileInfoList = new ArrayList<>();
		for (String filename : fileList) {
			File file = new File(filename);
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilename(file.getPath());
			fileInfo.setFilesize("" + file.length());
			Calendar cal = Calendar.getInstance();
			long time = file.lastModified();
			cal.setTimeInMillis(time);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cal.setTimeInMillis(time);
			// System.out.println("修改时间[2] " +
			// formatter.format(cal.getTime()));
			// System.out.println(getFileCreated(array[i]));
			fileInfo.setCreateDateStr(getFileCreated(file));
			fileInfo.setUpdateDateStr(formatter.format(cal.getTime()));
			fileInfo.setDeleteFlag("false");

			String[] nameArray = filename.split("\\\\");
			int length = nameArray.length;
			switch (length) {
			case 0:
				break;
			case 1:
				fileInfo.setName(nameArray[0]);
				break;
			case 2:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setName(nameArray[1]);
				break;
			case 3:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setLevel2(nameArray[1]);
				fileInfo.setName(nameArray[2]);
				break;
			case 4:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setLevel2(nameArray[1]);
				fileInfo.setLevel3(nameArray[2]);
				fileInfo.setName(nameArray[3]);
				break;
			case 5:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setLevel2(nameArray[1]);
				fileInfo.setLevel3(nameArray[2]);
				fileInfo.setLevel4(nameArray[3]);
				fileInfo.setName(nameArray[4]);
				break;
			case 6:
				fileInfo.setLevel1(nameArray[0]);
				fileInfo.setLevel2(nameArray[1]);
				fileInfo.setLevel3(nameArray[2]);
				fileInfo.setLevel4(nameArray[3]);
				fileInfo.setLevel5(nameArray[4]);
				fileInfo.setName(nameArray[5]);
				break;

			default:
				break;
			}

			fileInfoList.add(fileInfo);
		}
		logger.info("makeFileInfoList end");
		return fileInfoList;
	}

	public static void main(String[] args) {
		ReadDirectory rd = new ReadDirectory();
		// String dirPath = "E:\\百度云同步盘";

		String dirPath = "C:\\Camera";

		rd.printDir(dirPath);
		System.out.println("1		 ===============================================================");
		rd.readFile(dirPath);
		System.out.println("2		 ===============================================================");
		File file_path = new File(dirPath);
		File files[] = file_path.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
		}
		System.out.println("3		 ===============================================================");
		rd.getFile(dirPath);
		System.out.println("4		 ===============================================================");
		List<String> filenameList = new ArrayList<String>();
		rd.getFilenameList(dirPath, filenameList);
		for (String string : filenameList) {
			System.out.println(string);
		}
		System.out.println(filenameList.size());

		System.out.println("5 ===============================================================");
		Map<String, FileInfo> fileInfoMap = new TreeMap<String, FileInfo>();
		rd.getFile(dirPath, fileInfoMap);
		// 遍历map中的值

		for (FileInfo value : fileInfoMap.values()) {
			System.out.println("Value = " + value);
		}
		System.out.println(fileInfoMap.size());

		List<FileInfo> fileInfoList = rd.makeFileInfoList(fileInfoMap.values());
		for (FileInfo fileInfo : fileInfoList) {
			System.out.println(fileInfo);
		}
	}
}