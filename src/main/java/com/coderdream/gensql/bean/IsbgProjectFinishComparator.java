package com.coderdream.gensql.bean;

import java.util.Comparator;

import com.coderdream.util.DateUtil;

/**
 http://www.cnblogs.com/aheizi/p/5207870.html
 *
 */
public class IsbgProjectFinishComparator implements Comparator<IsbgProjectFinish> {

	/**
	 * 先按员工号排序，再按月份排序
	 */
	@Override
	public int compare(IsbgProjectFinish o1, IsbgProjectFinish o2) {

		String monthDate1 = o1.getProjectEndDateTime();
		String monthDate2 = o2.getProjectStartDateTime();

		if (DateUtil.compareTwoDate(monthDate1, monthDate2)) {
			return -1;
		} else if (DateUtil.compareTwoDate(monthDate2, monthDate1)) {
			return 1;
		}  
		return 0;
	}

}