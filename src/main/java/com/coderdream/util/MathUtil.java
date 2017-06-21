package com.coderdream.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author chenjiahui @2017-02-09
 * 
 */

public class MathUtil {
	
	public static int getRandomByRange(int min, int max) {
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		// System.out.println(s);

		return s;
	}

	public static Double sumNumberList(List<String> list) {
		//
		Double sum = new Double(0);
		for (String string : list) {
			sum += Double.parseDouble(string);
		}

		return sum;
	}
	
	public static Double setScale(Double dBsm, int scale) {
		BigDecimal b = new BigDecimal(dBsm);
		Double f1 = b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();

		return f1;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1.1");
		list.add("2.1");
		list.add("13.1");
		System.out.println(MathUtil.sumNumberList(list));
		
		MathUtil.getRandomByRange(8, 20);
		MathUtil.getRandomByRange(8, 20);
		MathUtil.getRandomByRange(8, 20);
		MathUtil.getRandomByRange(8, 20);

		// splitRedPacket(40000, 41, 300, 1500);
		// System.out.println("*****************");
		// splitRedPacket(20000, 30, 300, 1000);
		// System.out.println("*****************");
		// splitRedPacket(731, 20, 50, 250);

		// splitRedPacket(731, 20, 20, 250);
		// redPackage_02();
		// MathUtil mathUtil = new MathUtil();
		// // System.out.println(mathUtil.splitRedPackets(200, 100));
		//
		// float sum = 0.0f;
		// List<Float> floatList = mathUtil.splitRedPackets(200, 100);
		// for (Float float1 : floatList) {
		// System.out.println(float1);
		// sum += float1;
		// }
		// System.out.println(sum);

	}

	/**
	 * 
	 * @param total
	 *            总金额
	 * @param splitCount
	 *            个数
	 * @param min
	 *            最小金额
	 * @param max
	 *            最大金额
	 */
	public static void splitRedPacket(int total, int splitCount, int min, int max) {
		//System.out.println("总金额：    " + total);
		//System.out.println("个数： " + splitCount);
		//System.out.println("最小金额：   " + min);
		//System.out.println("最大金额：   " + max);

		ArrayList<Integer> al = new ArrayList<Integer>();
		Random random = new Random();

		if ((splitCount & 1) == 1) {// 奇数个红包，需要单独将其中一个红包先生成，以保证后续算法拆分份数为偶数。
			//System.out.println("红包个数" + splitCount + "是奇数，单独生成一个红包");
			int num = 0;
			do {
				num = random.nextInt(max);
				// num = (total - num) % (splitCount / 2) + num; //
				// 将后面算法拆分时的余数加入到这个随机值中。
				//System.out.println("单个的随机红包为：" + num);
			} while (num >= max || num <= min);

			total = 40000 - num;
			al.add(num);
		}
		int couples = splitCount >> 1;
		int perCoupleSum = total / couples;

		if ((splitCount & 1) == 1) {
			System.out.println("处理后剩余的金额为：" + total);
		}
		//System.out.println("将" + total + "元拆分为" + couples + "对金额，每对总额：" + perCoupleSum);

		for (int i = 0; i < couples; i++) {
			// Boolean finish = true;
			int num1 = 0;
			int num2 = 0;
			do {
				num1 = random.nextInt(max);
				num2 = perCoupleSum - num1;
				if (!al.contains(num1) && !al.contains(num2)) {
					if (i == 0) {
						num1 = (total - couples * perCoupleSum) + num1;
					}
				}
			} while (num1 < min || num1 > max || num2 < min || num2 > max);
			al.add(num1);
			al.add(num2);
		}

		int check_num = 0;
		Integer.compare(1, 2);
		al.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});

		//System.out.println(Arrays.toString(al.toArray()));

		for (int x : al) {
			check_num = check_num + x;
		}
		//System.out.println("验证总和：" + check_num);
	}

	public static void redPackage() {
		double min = 0.01;
		double total = 100.0;
		int count = 10;

		double last = total - min * count;

		for (int i = 0; i < count - 1; i++) {
			double avg = last / (count - i);
			double get = Math.random() * avg * 2 + min;
			//System.out.println("第" + (i + 1) + "个:" + get);
			last = last - get;
		}
		// last one
		//System.out.println("第" + count + "个" + (last + min));
	}

	private static final float MINMONEY = 0.01f;
	private static final float MAXMONEY = 200f;

	public static void redPackage_02() {
		float num = 10, N = 1.9f;
		int people = 10;
		for (int i = 0; i < 10; i++) {
			//System.out.println("the number" + people + "can get " + num / people * N);
			num = num - num / people * N;
			people--;
		}
		//System.out.println("there remain" + num);
	}

	private boolean isRight(float money, int count) {
		double avg = money / count;
		if (avg < MINMONEY) {
			return false;
		} else if (avg > MAXMONEY) {
			return false;
		}
		return true;
	}

	private float randomRedPacket(float money, float mins, float maxs, int count) {
		if (count == 1) {
			return (float) (Math.round(money * 100)) / 100;
		}
		if (mins == maxs) {
			return mins;// 如果最大值和最小值一样，就返回mins
		}
		float max = maxs > money ? money : maxs;
		float one = ((float) Math.random() * (max - mins) + mins);
		one = (float) (Math.round(one * 100)) / 100;
		float moneyOther = money - one;
		if (isRight(moneyOther, count - 1)) {
			return one;
		} else {
			// 重新分配
			float avg = moneyOther / (count - 1);
			if (avg < MINMONEY) {
				return randomRedPacket(money, mins, one, count);
			} else if (avg > MAXMONEY) {
				return randomRedPacket(money, one, maxs, count);
			}
		}
		return one;
	}

	private static final float TIMES = 2.1f;

	public List<Float> splitRedPackets(float money, int count) {
		if (!isRight(money, count)) {
			return null;
		}
		List<Float> list = new ArrayList<Float>();
		float max = (float) (money * TIMES / count);

		max = max > MAXMONEY ? MAXMONEY : max;
		for (int i = 0; i < count; i++) {
			float one = randomRedPacket(money, MINMONEY, max, count - i);
			list.add(one);
			money -= one;
		}
		return list;
	}

}