package com.coderdream.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class RedPacketUtil {

	/**
	 * @param total
	 *            总数
	 * @param count
	 *            个数
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @param time
	 *            最大值是平均值的倍数
	 * @return
	 */
	public static List<Integer> splitRedPackets(int total, int count, int min, int max, double time) {
		if (!isRight(total, count, min, max)) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		// 红包最大金额为平均金额的TIMES倍
		int maxNumber = (int) (total * time / count);
		maxNumber = maxNumber > max ? max : maxNumber;
		for (int i = 0; i < count; i++) {
			int one = random(total, min, maxNumber, count - i);
			if (1 == one) {
				System.out.println(one);
			}
			list.add(one);
			total -= one;
		}
		return list;
	}

	private static int random(int total, int minS, int maxS, int count) {
		// 红包数量为1，直接返回金额
		if (count == 1) {
			return total;
		}
		// 如果最大金额和最小金额相等，直接返回金额
		if (minS == maxS) {
			return minS;
		}
		int max = maxS > total ? total : maxS;
		// 分配红包正确情况，允许红包的最大值
		int maxY = total - (count - 1) * minS;
		// 分配红包正确情况，允许红包的最小值
		int minY = total - (count - 1) * maxS;
		// 随机产生红包的最小值
		int min = minY > minS ? minY : minS;
		// 随机产生红包最大值
		max = maxY < max ? maxY : max;
		// 随机产生一个红包
		return (int) Math.rint(Math.random() * (max - min) + min);
	}

	/**
	 * @param total
	 * @param count
	 * @return
	 * @Author:lulei
	 * @Description: 此种红包是否合法
	 */
	private static boolean isRight(int total, int count, int min, int max) {
		double avg = total / count;
		if (avg < min) {
			return false;
		}
		if (avg > max) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String beginDateString = "2016-01-01";
		// 总是
		int total = 730;
		// 个数
		int count = 20;
		// 最小额度
		int min = 15;
		// 最大额度
		int max = 150;
		// 最大额度是平均值的倍数
		double time = 6.1;
		List<Integer> integerList = splitRedPackets(total, count, min, max, time);
		List<String> dateStringList = getDateStringList(beginDateString, integerList);
		for (String string : dateStringList) {
			System.out.println(string);
		}

	}

	/**
	 * @param beginDateString
	 * @param total
	 *            总数
	 * @param count
	 *            个数
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @param time
	 *            最大值是平均值的倍数
	 * @return
	 */
	public static List<String> getDateStringList(String beginDateString, List<Integer> integerList) {
		List<String> dateStringList = new ArrayList<String>();
		dateStringList.add(beginDateString);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = df.parse(beginDateString);
			// System.out.println(date);
		} catch (ParseException e) {
			System.out.println("Unparseable using" + df);
		}

		Date newDate = new Date();// 取时间
		Date prewDate = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		Calendar calendar2 = new GregorianCalendar();

		// calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		// newDate = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		// System.out.println("新日期是:" + df.format(newDate));

		int sum = 0;
		int size = integerList.size();
		for (int i = 0; i < size; i++) {
			Integer integer = integerList.get(i);
			// System.out.println(integer);
			calendar.add(Calendar.DATE, integer);// 把日期往后增加一天.整数往后推,负数往前移动
			newDate = calendar.getTime(); // 这个时间就是日期往后推一天的结果
			calendar2.setTime(calendar.getTime());
			calendar2.add(Calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动
			prewDate = calendar2.getTime(); // 这个时间就是日期往后推一天的结果
			// System.out.println("新日期是:" + df.format(newDate));
			dateStringList.add(df.format(prewDate));
			// 最后一个数据不加开始日期
			if (i < size - 1) {
				dateStringList.add(df.format(newDate));
			}
			sum += integer;
		}
		System.out.println(sum);

		return dateStringList;
	}

}