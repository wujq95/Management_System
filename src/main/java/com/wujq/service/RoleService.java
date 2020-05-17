package com.wujq.service;

import java.util.List;
import java.util.Map;

import com.wujq.domain.Role;

public interface RoleService {
	Map<String, Object> roleList(Map<String, Object> map);
	Map<String, Object> roleAdd(Role role,Map<String, Object> map);
	Role load(Integer role_id);
	Map<String, Object> roleMdi(Role role,Map<String, Object> map);
	Map<String, Object> roleDel(Integer role_id,Map<String, Object> map);
	List<Role> roleAllList();
	Map<String, Object> menuMdi(Map<String, Object> map,Integer role_id);
	Map<String, Object> menuMdiDo(Map<String, Object> map);
}
