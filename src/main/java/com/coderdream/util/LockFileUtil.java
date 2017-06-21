package com.coderdream.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * http://www.cnblogs.com/yejg1212/archive/2013/03/31/2991963.html
 * Java文件锁定
 *
 */
public class LockFileUtil {

	public static void main(String[] args) throws Exception {
//		String filePath = "c:\\test.txt";
		
		String filePath = "D:\\Java\\GitHub\\CoderDreamUtil\\common-util\\target\\test-classes\\creatingDifferentTypesOfCells.xlsx";

		File file = new File(filePath);
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		FileChannel fc = raf.getChannel();
		FileLock fl = fc.tryLock();

		if (fl.isValid()) {
			System.out.println("Get the lock successed!");

			// 测试读线程
			ReadFile rf = new ReadFile(file);
			rf.start();

			// 测试写线程
			// WriteFile wf = new WriteFile(file,"This is a test！----幻影");
			// wf.start();

		}

		fl.release();
		System.out.println("release the lock!");
		raf.close();
	}
}

/****
 * 写文件
 * 
 * @author Administrator
 * 
 */
class WriteFile extends Thread {
	File file;
	String context;

	public WriteFile() {

	}

	public WriteFile(File file, String context) {
		this.file = file;
		this.context = context;
	}

	public void run() {
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);
			fw.write(context);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/****
 * 读文件
 * 
 * @author Administrator
 * 
 */
class ReadFile extends Thread {
	File file;

	public ReadFile() {
	}

	public ReadFile(File file) {
		this.file = file;
	}

	public void run() {
		FileReader fr = null;
		try {
			fr = new FileReader(file);

			int c;
			System.out.println("----------开始文件读取----------");
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println("");
			System.out.println("----------文件读取完毕----------");
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}