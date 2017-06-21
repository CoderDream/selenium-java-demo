package com.coderdream.readfolder.bean;

public class FileInfo {

	private String filename;
	private String level1;
	private String level2;
	private String level3;
	private String level4;
	private String level5;
	private String name;

	private String filesize;

	private String createDateStr;

	private String updateDateStr;

	private String deleteFlag = "false";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getLevel1() {
		return level1;
	}

	public void setLevel1(String level1) {
		this.level1 = level1;
	}

	public String getLevel2() {
		return level2;
	}

	public void setLevel2(String level2) {
		this.level2 = level2;
	}

	public String getLevel3() {
		return level3;
	}

	public void setLevel3(String level3) {
		this.level3 = level3;
	}

	public String getLevel4() {
		return level4;
	}

	public void setLevel4(String level4) {
		this.level4 = level4;
	}

	public String getLevel5() {
		return level5;
	}

	public void setLevel5(String level5) {
		this.level5 = level5;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "FileInfo [filename=" + filename + ", level1=" + level1 + ", level2=" + level2 + ", level3=" + level3
				+ ", level4=" + level4 + ", level5=" + level5 + ", name=" + name + ", filesize=" + filesize
				+ ", createDateStr=" + createDateStr + ", updateDateStr=" + updateDateStr + ", deleteFlag=" + deleteFlag
				+ "]";
	}

}
