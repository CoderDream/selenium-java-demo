package com.coderdream.gensql.bean;

/**
 */
public class IsbgProjectFinish {
		
	private String projectStartDateTime;
	
	private String projectEndDateTime;

	private String projectId;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectStartDateTime() {
		return projectStartDateTime;
	}

	public void setProjectStartDateTime(String projectStartDateTime) {
		this.projectStartDateTime = projectStartDateTime;
	}

	public String getProjectEndDateTime() {
		return projectEndDateTime;
	}

	public void setProjectEndDateTime(String projectEndDateTime) {
		this.projectEndDateTime = projectEndDateTime;
	}

	@Override
	public String toString() {
		return "IsbgProjectFinish [projectId=" + projectId + ", projectStartDateTime=" + projectStartDateTime
				+ ", projectEndDateTime=" + projectEndDateTime + "]";
	}
	
}