package com.coderdream.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class MyTimer {

	public static void main(String[] args) {
		//
		Timer timer = new Timer();

		MyTimerTask myTimerTask = new MyTimerTask("No.1");

		// timer.schedule(myTimerTask, 2000L, 1000L);
		/**
		 * <pre>
		 * 获取当前时间，并设置成距离当前时间三秒之后的时间
		 * 如当前时间是2016-11-10 23:59:57
		 * 则设置后的时间则为2016-11-11 00:00:00
		 * </pre>
		 */
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sf.format(calendar.getTime()));
		calendar.add(Calendar.SECOND, 3);

		// --- scheduale的用法
		/**
		 * 1.时间等于或超过time的时候执行且仅执行一次task 如在2016-11-11 00:00:00执行一次task：打印任务的名字
		 */
		// myTimerTask.setName("schedual1");
		// timer.schedule(myTimerTask, calendar.getTime());

		/**
		 * 2.
		 */
		// myTimerTask.setName("schedual_2");
		// timer.schedule(myTimerTask, calendar.getTime(), 2000);
		/**
		 * 3.等待delay毫秒后执行且执行一次task
		 */
		// myTimerTask.setName("schedule_3");
		// timer.schedule(myTimerTask, 3000);
		/**
		 * 4.等待delay毫秒后每隔period执行一次task
		 */
		// myTimerTask.setName("schedule_4");
		// timer.schedule(myTimerTask, 3000, 2000);
		/**
		 * 5
		 */
		// myTimerTask.setName("scheduleAtFixedRate_1");
		// timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000);
		/**
		 * 
		 */
		// myTimerTask.setName("scheduleAtFixedRate_2");
		// timer.scheduleAtFixedRate(myTimerTask, 3000, 2000);

		myTimerTask.setName("scheduleAtFixedRate_3");
		timer.schedule(myTimerTask, 3000);
		System.out.println("scheduled time is " + sf.format(myTimerTask.scheduledExecutionTime()));
	}
}
