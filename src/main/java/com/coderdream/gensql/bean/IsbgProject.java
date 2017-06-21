package com.coderdream.gensql.bean;

/**
 */
public class IsbgProject {

	private String projectId;
	
	private String projectNo;
	/** ProjectName */
	private String projectName;
	
	private String projectMgrWorkID;
	
	private String projectMgrName;
	
	private String projectStartDateTime;
	
	private String projectEndDateTime;
	
	private String pdrc;
	
	private String isFinish;
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectMgrWorkID() {
		return projectMgrWorkID;
	}

	public void setProjectMgrWorkID(String projectMgrWorkID) {
		this.projectMgrWorkID = projectMgrWorkID;
	}

	public String getProjectMgrName() {
		return projectMgrName;
	}

	public void setProjectMgrName(String projectMgrName) {
		this.projectMgrName = projectMgrName;
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

	public String getPdrc() {
		return pdrc;
	}

	public void setPdrc(String pdrc) {
		this.pdrc = pdrc;
	}

	public String getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}

	@Override
	public String toString() {
		return "IsbgProject [projectId=" + projectId + ", projectNo=" + projectNo + ", projectName=" + projectName + ", projectMgrWorkID="
				+ projectMgrWorkID + ", projectMgrName=" + projectMgrName + ", projectStartDateTime="
				+ projectStartDateTime + ", projectEndDateTime=" + projectEndDateTime + ", pdrc=" + pdrc + ", isFinish="
				+ isFinish + "]";
	}
		
	
}