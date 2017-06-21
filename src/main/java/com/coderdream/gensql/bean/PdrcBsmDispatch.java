package com.coderdream.gensql.bean;

/**
 */
public class PdrcBsmDispatch {
	
	private String projectID;

	private String staffWorkID;

	private String dispatchMonth;

	private String confrimTime;

	private String bsmState;

	private String bsm;

	public String getStaffWorkID() {
		return staffWorkID;
	}

	public void setStaffWorkID(String staffWorkID) {
		this.staffWorkID = staffWorkID;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getDispatchMonth() {
		return dispatchMonth;
	}

	public void setDispatchMonth(String dispatchMonth) {
		this.dispatchMonth = dispatchMonth;
	}

	public String getConfrimTime() {
		return confrimTime;
	}

	public void setConfrimTime(String confrimTime) {
		this.confrimTime = confrimTime;
	}

	public String getBsmState() {
		return bsmState;
	}

	public void setBsmState(String bsmState) {
		this.bsmState = bsmState;
	}

	public String getBsm() {
		return bsm;
	}

	public void setBsm(String bsm) {
		this.bsm = bsm;
	}

	@Override
	public String toString() {
		return "PdrcBsmDispatch [projectID=" + projectID + ", dispatchMonth="
				+ dispatchMonth + ", staffWorkID=" + staffWorkID + ", confrimTime=" + confrimTime + ", bsmState=" + bsmState + ", bsm=" + bsm + "]";
	}

}