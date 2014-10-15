package com.dais.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="sys_permissions")
public class Permissions extends BaseEntity{
	private String name;
	private String code;
	
	@Column(name="f_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	@Column(name="f_code")
	public void setCode(String code) {
		this.code = code;
	}
	
}
