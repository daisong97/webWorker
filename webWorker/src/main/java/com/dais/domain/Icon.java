package com.dais.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sys_icons")
public class Icon extends BaseEntity {
	private String name;
	private int status;
	private int type;
	
	@Column(name="f_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="f_status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name="f_type")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
