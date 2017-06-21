package com.coderdream.gensql.bean;

import java.util.Comparator;

import com.coderdream.util.DateUtil;

/**
 * http://www.cnblogs.com/aheizi/p/5207870.html
 *
 */
public class MemberParticipateComparator implements Comparator<MemberParticipate> {

	/**
	 * 先按员工号排序，再按月份排序
	 */
	@Override
	public int compare(MemberParticipate o1, MemberParticipate o2) {
		String projectID1 = o1.getProjectID();
		String projectID2 = o2.getProjectID();

		String workID1 = o1.getStaffWorkID();
		String workID2 = o2.getStaffWorkID();

		String[] arr1 = workID1.split("-");
		String[] arr2 = workID2.split("-");

		int work1 = Integer.parseInt(arr1[1]);
		int work2 = Integer.parseInt(arr2[1]);

		String dispatchMonth1 = o1.getMonthDate();
		String dispatchMonth2 = o2.getMonthDate();

		// String monthDate1 = o1.getDispatchMonth();
		// String monthDate2 = o2.getDispatchMonth();

		// if (projectID2.compareTo(projectID1) > 0) {
		// return 1;
		// } else if (projectID1.compareTo(projectID2) > 0) {
		// return -1;
		if (projectID2.compareTo(projectID1) > 0) {
			return 1;
		} else if (projectID1.compareTo(projectID2) > 0) {
			return -1;
		} else if (work1 < work2) {
			return -1;
		} else if (work1 > work2) {
			return 1;
		} else if (DateUtil.compareTwoDate(dispatchMonth1, dispatchMonth2)) {
			return -1;
		} else if (DateUtil.compareTwoDate(dispatchMonth2, dispatchMonth1)) {
			return 1;
		} else {
			return 0;
		}
			
	}

}