package com.coderdream.gensql.bean;

/**
 */
public class Menu {

	private String role;

	private String menuName;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "Menu [role=" + role + ", menuName=" + menuName + "]";
	}

}