package com.coderdream.gensql.bean;

/**
 */
public class PdrcEnpPrize {

	private String workID;

	private String monthDate;

	private String prize;

	public String getWorkID() {
		return workID;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getMonthDate() {
		return monthDate;
	}

	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "PdrcBenpPrize [workID=" + workID + ", monthDate=" + monthDate + ", prize=" + prize + "]";
	}

}