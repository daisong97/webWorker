package com.dais.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sys_permissions_group")
public class PermissionsGroup extends BaseEntity{
		private String name;
		
		private Set<Permissions> permissionItem;
		
		private int code;
		
		@Column(name="f_name")
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCode() {
			return code;
		}
		@Column(name="f_code")
		public void setCode(int code) {
			this.code = code;
		}
		
		@OneToMany(targetEntity=Permissions.class,fetch=FetchType.EAGER)
		public Set<Permissions> getPermissionItem() {
			return permissionItem;
		}
		public void setPermissionItem(Set<Permissions> permissionItem) {
			this.permissionItem = permissionItem;
		}
		
		
}
