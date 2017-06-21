package com.coderdream.gensql.bean;

/**
 */
public class PdrcStaffManage {

	/** 员工号 */
	private String workID;

	/** 员工姓名 */
	private String userName;

	/** 标准人定额 */
	private String normalMam;

	/** TM工号 */
	private String tmWorkID;

	/** TM姓名 */
	private String tmName;

	/** */
	private String salary;

	public String getWorkID() {
		return workID;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getTmWorkID() {
		return tmWorkID;
	}

	public void setTmWorkID(String rmWorkID) {
		this.tmWorkID = rmWorkID;
	}

	public String getNormalMam() {
		return normalMam;
	}

	public void setNormalMam(String normalMam) {
		this.normalMam = normalMam;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTmName() {
		return tmName;
	}

	public void setTmName(String tmName) {
		this.tmName = tmName;
	}

	@Override
	public String toString() {
		return "PdrcStaffManage [workID=" + workID + ", userName=" + userName + ", normalMam=" + normalMam
				+ ", tmWorkID=" + tmWorkID + ", tmName=" + tmName + ", salary=" + salary + "]";
	}

}