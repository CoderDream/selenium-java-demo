package com.coderdream.readfolder.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	public static LinkedList<File> traverseFolder1(String strPath) {
		LinkedList<File> list = new LinkedList<File>();
		long startTime = System.nanoTime(); // 获取开始时间
		int fileNum = 0, folderNum = 0;
		File file = new File(strPath);
		if (file.exists()) {

			File[] files = file.listFiles();
			for (File file2 : files) {
				if (file2.isDirectory()) {
					logger.debug("文件夹:" + file2.getAbsolutePath());

					fileNum++;
				} else {
					logger.debug("文件:" + file2.getAbsolutePath());
					folderNum++;
					list.add(file2);
				}
			}
			File temp_file;
			while (!list.isEmpty()) {
				temp_file = list.removeFirst();
				files = temp_file.listFiles();
				for (File file2 : files) {
					if (file2.isDirectory()) {
						logger.debug("文件夹:" + file2.getAbsolutePath());
						fileNum++;
					} else {
						logger.debug("文件:" + file2.getAbsolutePath());
						folderNum++;
						list.add(file2);
					}
				}
			}
		} else {
			logger.debug("文件不存在!");
		}

		logger.debug("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
		long endTime = System.nanoTime(); // 获取结束时间
		logger.debug("程序运行时间： " + (endTime - startTime) + "ns");

		return list;
	}

	public static void traverseFolder2(String strPath) {
		long startTime = System.nanoTime(); // 获取开始时间
		File file = new File(strPath);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				logger.debug("文件夹是空的!");
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						logger.debug("文件夹:" + file2.getAbsolutePath());
						traverseFolder2(file2.getAbsolutePath());
					} else {
						logger.debug("文件:" + file2.getAbsolutePath());
					}
				}
			}
		} else {
			logger.debug("文件不存在!");
		}
		long endTime = System.nanoTime(); // 获取结束时间

		logger.debug("程序运行时间： " + (endTime - startTime) + "ns");
	}

	public static List<File> getFileList(String strPath) {
		long startTime = System.nanoTime(); // 获取开始时间
		List<File> filelist = new ArrayList<File>();
		File dir = new File(strPath);
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				// String fileName = files[i].getName();
				if (files[i].isDirectory()) { // 判断是文件还是文件夹
					getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
					// } else if (fileName.endsWith("avi")) { // 判断文件名是否以.avi结尾
					// String strFileName = files[i].getAbsolutePath();
					// System.out.println("---" + strFileName);
					// filelist.add(files[i]);
				} else {
					// continue;
					String strFileName = files[i].getAbsolutePath();
					logger.debug("---" + strFileName);
					filelist.add(files[i]);
				}
			}

		}
		long endTime = System.nanoTime(); // 获取结束时间

		logger.debug("程序运行时间： " + (endTime - startTime) + "ns");
		return filelist;
	}

	public static void write(List<String> stringList, String filename, String charsetName) {
		try {
			// FileOutputStream fos=new
			// FileOutputStream("C:/Users/Administrator/Desktop/userword.dict");
			FileOutputStream fos = new FileOutputStream(filename);
			OutputStreamWriter osw = new OutputStreamWriter(fos, charsetName);
			BufferedWriter bw = new BufferedWriter(osw);
			// BufferedWriter writer = new BufferedWriter(new
			// OutputStreamWriter(new FileOutputStream(file), encoding));
			for (String string : stringList) {
				bw.write(string + "\n");
			}
			bw.flush();
			fos.close();
			osw.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
