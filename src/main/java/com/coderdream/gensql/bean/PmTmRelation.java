package com.coderdream.gensql.bean;

import java.util.List;

/**
 */
public class PmTmRelation {

	private String pmWorkID;

	private String tmWorkID;

	private List<String> workIDList;

	public String getPmWorkID() {
		return pmWorkID;
	}

	public void setPmWorkID(String pmWorkID) {
		this.pmWorkID = pmWorkID;
	}

	public String getTmWorkID() {
		return tmWorkID;
	}

	public void setTmWorkID(String rmWorkID) {
		this.tmWorkID = rmWorkID;
	}

	public List<String> getWorkIDList() {
		return workIDList;
	}

	public void setWorkIDList(List<String> workIDList) {
		this.workIDList = workIDList;
	}

}