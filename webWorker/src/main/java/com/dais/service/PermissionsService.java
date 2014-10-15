package com.dais.service;

import java.util.Set;

public interface PermissionsService {
	/**
	 * 列出所有的权限组合
	 * @param permissions
	 * @return
	 */
	public Set<String> listPermissions(String userName);
}
