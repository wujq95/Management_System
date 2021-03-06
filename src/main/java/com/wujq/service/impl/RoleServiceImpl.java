package com.wujq.service.impl;

import java.util.List;
import java.util.Map;

import com.wujq.domain.Menu;
import com.wujq.domain.Rlm;
import com.wujq.domain.Role;
import com.wujq.mapper.MenuMapper;
import com.wujq.mapper.RlmMapper;
import com.wujq.mapper.RoleMapper;
import com.wujq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wujq.util.PageBean;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RlmMapper rlmMapper;
	@Autowired
	private MenuMapper menuMapper;

	/**
	 * check role
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> roleList(Map<String, Object> map) {
		List<Role> roleList = roleMapper.roleList(map);
		int count = roleMapper.count(map);
		PageBean.serMap(map, count, roleList, Role.class);
		return map;
	}

	/**
	 * role add
	 * @param role
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> roleAdd(Role role, Map<String, Object> map) {
		int result = roleMapper.add(role);
		if(result>0){
			map.put("message", "successfully added");
		}else {
			map.put("message", "fail to add");
		}
		return map;
	}

	/**
	 * role load
	 * @param role_id
	 * @return
	 */
	@Override
	public Role load(Integer role_id) {
		return roleMapper.load(role_id);
	}

	/**
	 * role modify
	 * @param role
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> roleMdi(Role role, Map<String, Object> map) {
		int result = roleMapper.update(role);
		if(result>0){
			map.put("message", "successfully modified");
		}else {
			map.put("message", "fail to modify");
		}
		return map;
	}

	/**
	 * role delete
	 * @param role_id
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> roleDel(Integer role_id, Map<String, Object> map) {
		int result = roleMapper.delete(role_id);
		if(result>0){
			map.put("message", "successfully deleted");
		}else {
			map.put("message", "fail to delete");
		}
		return map;
	}

	/**
	 * check role list
	 * @return
	 */
	@Override
	public List<Role> roleAllList() {
		return roleMapper.roleAllList();
	}

	/**
	 * menu modify first part
	 * @param map
	 * @param role_id
	 * @return
	 */
	@Override
	public Map<String, Object> menuMdi(Map<String, Object> map, Integer role_id) {
		List<Rlm> havList = rlmMapper.havList(role_id);
		map.put("havList", havList);
		List<Menu> noList = menuMapper.noList(role_id);
		map.put("noList", noList);
		return map;
	}

	/**
	 * menu modify second part
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> menuMdiDo(Map<String, Object> map) {
		rlmMapper.menuDel(map);
		Integer[] fk_menu_ids = (Integer[])map.get("fk_menu_ids");
		if(fk_menu_ids!=null&&fk_menu_ids.length>0){
			rlmMapper.menuAdd(map);
		}
		map.put("message", "successfully assigned");
		return map;
	}
}
