package com.dais.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sys_user")
public class User extends BaseEntity{
	public String name;
	public String loginName;
	public String password;
	public List<PermissionsGroup> permissionsGroup;
	
	
	@Column(name="f_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(fetch=FetchType.EAGER,targetEntity=PermissionsGroup.class)
	public List<PermissionsGroup> getPermissionsGroup() {
		return permissionsGroup;
	}
	public void setPermissionsGroup(List<PermissionsGroup> permissionsGroup) {
		this.permissionsGroup = permissionsGroup;
	}
	
	
}
