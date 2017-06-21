package com.coderdream.gensql.bean;

/**
 */
public class IsbgHumanMap {

	private String staffWorkID;

	private String staffName;
	
	private String projectID;
	
	private String inProDate;

	private String inProState;
	
	private String outProDate;

	private String predictOutProDate;
	
	private String isPay;
	
	public String getStaffWorkID() {
		return staffWorkID;
	}
	public void setStaffWorkID(String staffWorkID) {
		this.staffWorkID = staffWorkID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getInProDate() {
		return inProDate;
	}
	public void setInProDate(String inProDate) {
		this.inProDate = inProDate;
	}
	public String getInProState() {
		return inProState;
	}
	public void setInProState(String inProState) {
		this.inProState = inProState;
	}
	public String getOutProDate() {
		return outProDate;
	}
	public void setOutProDate(String outProDate) {
		this.outProDate = outProDate;
	}
	public String getPredictOutProDate() {
		return predictOutProDate;
	}
	public void setPredictOutProDate(String predictOutProDate) {
		this.predictOutProDate = predictOutProDate;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	@Override
	public String toString() {
		return "IsbgHumanMap [staffWorkID=" + staffWorkID + ", staffName=" + staffName + ", projectID=" + projectID
				+ ", inProDate=" + inProDate + ", inProState=" + inProState + ", outProDate=" + outProDate
				+ ", predictOutProDate=" + predictOutProDate + ", isPay=" + isPay + "]";
	}

}