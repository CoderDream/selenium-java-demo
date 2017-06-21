package com.coderdream.gensql.bean;

/**
 */
public class PdrcTm {

	/** 表名 */
	private String workID;
	/** 表说明 */
	private String rmWorkID;
	
	public String getWorkID() {
		return workID;
	}
	public void setWorkID(String workID) {
		this.workID = workID;
	}
	public String getRmWorkID() {
		return rmWorkID;
	}
	public void setRmWorkID(String rmWorkID) {
		this.rmWorkID = rmWorkID;
	}
	@Override
	public String toString() {
		return "PdrcTm [workID=" + workID + ", rmWorkID=" + rmWorkID + "]";
	}
	
}