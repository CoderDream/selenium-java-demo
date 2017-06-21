package com.coderdream.gensql.bean;

/**
 */
public class PdrcTmSalary {

	private String tmWorkID;

	private String monthDate;

	private String totalSalary;

	private String averageSalary;

	public String getTmWorkID() {
		return tmWorkID;
	}

	public void setTmWorkID(String tmWorkID) {
		this.tmWorkID = tmWorkID;
	}

	public String getMonthDate() {
		return monthDate;
	}

	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}

	public String getAverageSalary() {
		return averageSalary;
	}

	public void setAverageSalary(String averageSalary) {
		this.averageSalary = averageSalary;
	}

	public String getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(String totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		return "PdrcTmSalary [tmWorkID=" + tmWorkID + ", monthDate=" + monthDate + ", totalSalary=" + totalSalary
				+ ", averageSalary=" + averageSalary + "]";
	}
	
}