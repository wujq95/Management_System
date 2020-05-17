package com.wujq.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.wujq.domain.Role;
import com.wujq.service.RoleService;
import com.wujq.util.PageBean;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@RequestMapping("/roleList")
	public String roleList(Map<String,Object> map,@RequestParam(required=false,defaultValue="1") int pages,@RequestParam(required=false,defaultValue="5") int num,Role role,HttpServletRequest request){
		PageBean.conMap(map, pages, num, request, Role.class);
		roleService.roleList(map);
		return "role/roleList";
	}
	@RequestMapping("/roleAdd")
	public String roleAdd(){

		return "role/roleAdd";
	}
	@RequestMapping("/roleAddDo")
	public String roleAddDo(Role role,Map<String, Object> map) {
		roleService.roleAdd(role, map);
		return "main/message";
	}
	@RequestMapping("/roleMdi")
	public String roleMdi(Integer role_id,Map<String, Object> map){
		Role role = roleService.load(role_id);
		map.put("role", role);
		return "role/roleMdi";
	}
	@RequestMapping("/roleMdiDo")
	public String roleMdiDo(Role role,Map<String, Object> map) {
		roleService.roleMdi(role, map);
		return "main/message";
	}
	@RequestMapping("/roleDel")
	public String roleDel(Integer role_id,Map<String, Object> map){
		map.put("role_id", role_id);
		return "role/roleDel";
	}
	@RequestMapping("/roleDelDo")
	public String roleDelDo(Integer role_id,Map<String, Object> map){
		roleService.roleDel(role_id, map);
		return "main/message";
	}
	@RequestMapping("/menuMdi")
	public String menuMdi(Integer role_id,Map<String,Object> map){
		roleService.menuMdi(map, role_id);
		map.put("role_id", role_id);
		return "menu/menuMdi";
	}
	@RequestMapping("/menuMdiDo")
	public String menuMdiDo(Integer role_id,Map<String,Object> map,Integer[] selectR){
		map.put("fk_role_id", role_id);
		map.put("fk_menu_ids", selectR);
		roleService.menuMdiDo(map);
		return "main/message";
	}
}
