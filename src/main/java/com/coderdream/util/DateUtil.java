package com.coderdream.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DateUtil {

	/**
	 * @param beginDateString
	 * @return
	 */
	public static boolean beforeToday(String beginDateString) {
		Date date = new Date();

		SimpleDateFormat df = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);
		try {
			date = df.parse(beginDateString);
			// System.out.println(date);
		} catch (ParseException e) {
			System.out.println("Unparseable using" + df);
		}
		Date totalDate = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		Calendar calendarToday = new GregorianCalendar();
		calendarToday.setTime(totalDate);
		calendarToday.add(Calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动

		return calendarToday.after(calendar);
	}

	/**
	 * @param beginDateString
	 * @return
	 */
	public static boolean beforeDate(String beginDateString, String endDateString) {
		Date beginDateDate = new Date();
		Date endDateDate = new Date();// 取时间

		SimpleDateFormat df = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);
		try {
			beginDateDate = df.parse(beginDateString);
			endDateDate = df.parse(endDateString);
		} catch (ParseException e) {
			System.out.println("Unparseable using" + df);
		}

		Calendar calendarBegin = new GregorianCalendar();
		calendarBegin.setTime(beginDateDate);

		Calendar calendarEnd = new GregorianCalendar();
		calendarEnd.setTime(endDateDate);
		// calendarEnd.add(Calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动

		return calendarEnd.after(calendarBegin);
	}

	/**
	 * @param oneDateString
	 * @param secondDateString
	 * @return
	 */
	public static boolean compareTwoDate(String oneDateString, String secondDateString) {
		Date dateOne = new Date();
		Date dateTwo = new Date();// 取时间

		SimpleDateFormat df = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);
		try {
			dateOne = df.parse(oneDateString);
			dateTwo = df.parse(secondDateString);
		} catch (ParseException e) {
			System.out.println("Unparseable using" + df);
		}

		Calendar calendarOne = new GregorianCalendar();
		calendarOne.setTime(dateOne);

		Calendar calendarSecond = new GregorianCalendar();
		calendarSecond.setTime(dateTwo);

		return calendarSecond.after(calendarOne);
	}

	/**
	 * @param beginDateString
	 * @param endDateString
	 * @return
	 */
	public static boolean betweenTwoDate(String dateString, String beginDateString, String endDateString) {
		Date dateMiddle = new Date();
		Date dateOne = new Date();
		Date dateTwo = new Date();// 取时间

		SimpleDateFormat df = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);
		try {
			dateMiddle = df.parse(dateString);
			dateOne = df.parse(beginDateString);
			dateTwo = df.parse(endDateString);
		} catch (ParseException e) {
			System.out.println("Unparseable using" + df);
		}

		Calendar calendarOne = new GregorianCalendar();
		calendarOne.setTime(dateOne);
		calendarOne.add(Calendar.DATE, -1);

		Calendar calendarSecond = new GregorianCalendar();
		calendarSecond.setTime(dateTwo);
		calendarSecond.add(Calendar.DATE, 1);

		Calendar calendarMiddle = new GregorianCalendar();
		calendarMiddle.setTime(dateMiddle);

		return calendarMiddle.after(calendarOne) && calendarMiddle.before(calendarSecond);
	}

	/**
	 * @param dateString
	 * @param count
	 * @return
	 */
	public static String getNextDate(String dateString, Integer count) {
		Date dateOne = new Date();

		SimpleDateFormat df = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);
		try {
			dateOne = df.parse(dateString);
		} catch (ParseException e) {
			System.out.println("Unparseable using" + df);
		}

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateOne);
		calendar.add(Calendar.DATE, count);

		return df.format(calendar.getTime());
	}

	/**
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) {
		List<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);// 格式化为年月

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		try {
			min.setTime(sdf.parse(minDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

		try {
			max.setTime(sdf.parse(maxDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}

		return result;
	}

	/**
	 * @param dateStr
	 * @return
	 */
	public static String getMonthEnd(String dateStr) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);// 格式化为年月

		Calendar min = Calendar.getInstance();

		try {
			min.setTime(sdf.parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
		min.add(Calendar.MONTH, 1);
		min.add(Calendar.DATE, -1);

		result = sdf.format(min.getTime());

		return result;
	}

	/**
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static List<Double> getMonthBetweenParticipate(String beginDate, String endDate) {
		List<Double> participateList = new ArrayList<Double>();
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);// 格式化为年月

		Calendar beginCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();

		try {
			beginCal.setTime(sdf.parse(beginDate));
			endCal.setTime(sdf.parse(endDate));

			List<String> monthStrList = getMonthBetween(beginDate, endDate);
			Calendar currentMonth = Calendar.getInstance();
			Calendar nextMonth = Calendar.getInstance();
			for (String string : monthStrList) {
				currentMonth.setTime(sdf.parse(string));
				nextMonth.setTime(sdf.parse(string));
				nextMonth.add(Calendar.MONTH, 1);
				// 获取当月天数
				int monthRange = getDateRangeExcludeEnd(currentMonth, nextMonth);
				// 获取跨度，如果endDate大于等于下月第一天
				//
				boolean beginDateFlag = beginCal.after(currentMonth);
				//
				boolean endDateFlag = endCal.before(nextMonth);
				int dayRange = 0;
				if (endDateFlag) {
					if (beginDateFlag) {
						dayRange = getDateRange(beginCal, endCal);
					} else {
						dayRange = getDateRange(currentMonth, endCal); // DONE
					}
				} else {
					if (beginDateFlag) {
						dayRange = getDateRangeExcludeEnd(beginCal, nextMonth);
					} else {
						dayRange = getDateRangeExcludeEnd(currentMonth, nextMonth); // DONE
					}
				}
				Double dayRangeDouble = Double.valueOf(dayRange);
				Double monthRangeDouble = Double.valueOf(monthRange);
				Double temp = dayRangeDouble / monthRangeDouble;
				participateList.add(temp);
				// System.out.println("dayRange \t" + dayRange);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return participateList;
	}

	/**
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Map<String, Double> getMonthBetweenParticipateWithMonth(String beginDate, String endDate) {
		Map<String, Double> participateMap = new TreeMap<String, Double>();
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);// 格式化为年月

		Calendar beginCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();

		try {
			beginCal.setTime(sdf.parse(beginDate));
			endCal.setTime(sdf.parse(endDate));

			List<String> monthStrList = getMonthBetween(beginDate, endDate);
			Calendar currentMonth = Calendar.getInstance();
			Calendar nextMonth = Calendar.getInstance();
			for (String string : monthStrList) {
				currentMonth.setTime(sdf.parse(string));
				nextMonth.setTime(sdf.parse(string));
				nextMonth.add(Calendar.MONTH, 1);
				// 获取当月天数
				int monthRange = getDateRangeExcludeEnd(currentMonth, nextMonth);
				// 获取跨度，如果endDate大于等于下月第一天
				//
				boolean beginDateFlag = beginCal.after(currentMonth);
				//
				boolean endDateFlag = endCal.before(nextMonth);
				int dayRange = 0;
				if (endDateFlag) {
					if (beginDateFlag) {
						dayRange = getDateRange(beginCal, endCal);
					} else {
						dayRange = getDateRange(currentMonth, endCal); // DONE
					}
				} else {
					if (beginDateFlag) {
						dayRange = getDateRangeExcludeEnd(beginCal, nextMonth);
					} else {
						dayRange = getDateRangeExcludeEnd(currentMonth, nextMonth); // DONE
					}
				}
				Double dayRangeDouble = Double.valueOf(dayRange);
				Double monthRangeDouble = Double.valueOf(monthRange);
				Double temp = dayRangeDouble / monthRangeDouble;
				participateMap.put(sdf.format(currentMonth.getTime()), temp);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return participateMap;
	}

	/**
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Double getMonthBetweenParticipateSum(String beginDate, String endDate) {
		Double participateSum = new Double(0);

		List<Double> participateList = DateUtil.getMonthBetweenParticipate(beginDate, endDate);
		for (Double participateDouble : participateList) {
			participateSum += participateDouble;
		}

		return participateSum;
	}

	/**
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDateRange(String date1, String date2) {
		Calendar calst = Calendar.getInstance();
		Calendar caled = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);// 格式化为年月
		try {
			calst.setTime(df.parse(date1));
			caled.setTime(df.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 设置时间为0时
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;

		return days + 1;
	}

	/**
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDateRange(Calendar beginCal, Calendar endCal) {
		// 设置时间为0时
		beginCal.set(Calendar.HOUR_OF_DAY, 0);
		beginCal.set(Calendar.MINUTE, 0);
		beginCal.set(Calendar.SECOND, 0);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (endCal.getTime().getTime() / 1000) - (int) (beginCal.getTime().getTime() / 1000)) / 3600
				/ 24;

		return days + 1;
	}

	/**
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDateRangeExcludeEnd(String date1, String date2) {
		Calendar calst = Calendar.getInstance();
		Calendar caled = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);// 格式化为年月
		try {
			calst.setTime(df.parse(date1));
			caled.setTime(df.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 设置时间为0时
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;

		return days;
	}

	/**
	 * @param calst
	 * @param caled
	 * @return
	 */
	public static int getDateRangeExcludeEnd(Calendar calst, Calendar caled) {
		// 设置时间为0时
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;

		return days;
	}

	public static void main(String[] args) {

		System.out.println(DateUtil.getNextDate("2017-05-15", 5));
		// String beginDateString1 = ;
		// String beginDateString2 = "2017-05-16";
		// String beginDateString3 = "2017-05-17";
		// String beginDateString4 = "2017-05-18";
		// String beginDateString5 = "2017-12-31";
		// System.out.println(DateUtil.beforeTotal(beginDateString1));
		// System.out.println(DateUtil.beforeTotal(beginDateString2));
		// System.out.println(DateUtil.beforeTotal(beginDateString3));
		// System.out.println(DateUtil.beforeTotal(beginDateString4));
		// System.out.println(DateUtil.beforeTotal(beginDateString5));

		System.out.println(DateUtil.compareTwoDate("2017-01-01", "2017-01-02"));
		System.out.println(DateUtil.compareTwoDate("2017-01-02", "2017-01-02"));
		System.out.println(DateUtil.compareTwoDate("2017-01-03", "2017-01-02"));

		String beginDateString1 = "2017-01-01";
		String endDateString1 = "2017-03-05";
		String beginDateString2 = "2016-11-11";
		String endDateString2 = "2017-05-05";
		String beginDateString3 = "2017-02-15";
		String endDateString3 = "2017-10-21";
		System.out.println(DateUtil.getMonthBetween(beginDateString1, endDateString1));
		System.out.println(DateUtil.getMonthBetween(beginDateString2, endDateString2));
		System.out.println(DateUtil.getMonthBetween(beginDateString3, endDateString3));
	}
}
