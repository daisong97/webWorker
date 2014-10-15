package com.dais.ext;

import java.util.List;

/**
 * 分页手的数据集合
 * @author dais
 *
 * @param <T>
 */
public class Pageable{
	private int total;
	private List rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
