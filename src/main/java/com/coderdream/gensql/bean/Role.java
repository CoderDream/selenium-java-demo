package com.coderdream.gensql.bean;

/**
 */
public class Role {

	private String workID;

	private String role;

	public String getWorkID() {
		return workID;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [workID=" + workID + ", role=" + role + "]";
	}

}