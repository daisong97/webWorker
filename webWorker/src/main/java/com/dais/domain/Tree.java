package com.dais.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 菜单
 * @author dais
 *
 */
/*@Entity
@Table(name="sys_tree")*/
public class Tree extends BaseEntity {
	@Column(name="text")
	String text;

	@Column(name="type")
	Integer type;
	
	@Column(name="iconCls")
	String iconCls;
	
	@JsonIgnore
	Tree parent;
	
	Set<Tree> children;
	
	@ManyToOne(targetEntity=Tree.class)
	public Tree getParent() {
		return parent;
	}
	public void setParent(Tree parent) {
		this.parent = parent;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@OneToMany(targetEntity=Tree.class,fetch=FetchType.EAGER)
	public Set<Tree> getChildren() {
		return children;
	}
	public void setChildren(Set<Tree> children) {
		this.children = children;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
}
