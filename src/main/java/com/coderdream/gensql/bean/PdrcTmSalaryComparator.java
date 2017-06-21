package com.coderdream.gensql.bean;

import java.util.Comparator;

import com.coderdream.util.DateUtil;

/**
 http://www.cnblogs.com/aheizi/p/5207870.html
 *
 */
public class PdrcTmSalaryComparator implements Comparator<PdrcTmSalary> {

	/**
	 * 先按员工号排序，再按月份排序
	 */
	@Override
	public int compare(PdrcTmSalary o1, PdrcTmSalary o2) {
		String workID1 = o1.getTmWorkID();
		String workID2 = o2.getTmWorkID();

		String[] arr1 = workID1.split("-");
		String[] arr2 = workID2.split("-");

		int work1 = Integer.parseInt(arr1[1]);
		int work2 = Integer.parseInt(arr2[1]);

		String monthDate1 = o1.getMonthDate();
		String monthDate2 = o2.getMonthDate();

		if (work1 < work2) {
			return -1;
		} else if (work1 > work2) {
			return 1;
		} else if (DateUtil.compareTwoDate(monthDate1, monthDate2)) {
			return -1;
		} else if (DateUtil.compareTwoDate(monthDate2, monthDate1)) {
			return 1;
		}  
		return 0;
	}

}