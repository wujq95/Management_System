package com.wujq.controller;

import com.wujq.domain.Role;
import com.wujq.service.RoleService;
import com.wujq.util.GetIds;
import com.wujq.util.PageBean;
import com.wujq.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wujq.domain.User;
import com.wujq.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	/**
	 * check user controller
	 * @param map
	 * @param pages
	 * @param num
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/userList")
	public String userList(Map<String,Object> map,@RequestParam(required=false,defaultValue="1") int pages,@RequestParam(required=false,defaultValue="5") int num,User user,HttpServletRequest request){
		PageBean.conMap(map, pages, num, request, User.class);
		userService.userList(map);
		return "user/userList";
	}

	/**
	 * add user first controller
	 * @param map
	 * @return
	 */
	@RequestMapping("/userAdd")
	public String userAdd(Map<String, Object> map){
		List<Role> roleAllList = roleService.roleAllList();
		map.put("roleAllList", roleAllList);
		return "user/userAdd";
	}

	/**
	 * add user second controller
	 * @param user
	 * @param photo
	 * @param map
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/userAddDo")
	public String userAddDo(User user,MultipartFile photo,Map<String, Object> map,HttpServletRequest request) throws IllegalStateException, IOException{
		UploadFile.upload(user,photo,request);
		userService.userAdd(user, map);
		return "main/message";
	}

	/**
	 * modify user first controller
	 * @param user_id
	 * @param map
	 * @return
	 */
	@RequestMapping("/userMdi")
	public String userMdi(Integer user_id,Map<String, Object> map){
		User user = userService.load(user_id);
		map.put("user", user);
		List<Role> roleAllList = roleService.roleAllList();
		map.put("roleAllList", roleAllList);
		return "user/userMdi";
	}

	/**
	 * modify user second controller
	 * @param user
	 * @param photo
	 * @param map
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/userMdiDo")
	public String userMdiDo(User user,MultipartFile photo,Map<String, Object> map,HttpServletRequest request) throws IllegalStateException, IOException{
		UploadFile.upload(user,photo,request);
		userService.userMdi(user, map);
		return "main/message";
	}

	/**
	 * delete user first controller
	 * @param user_id
	 * @param map
	 * @return
	 */
	@RequestMapping("/userDel")
	public String userDel(Integer user_id,Map<String, Object> map){
		map.put("user_id", user_id);
		return "user/userDel";
	}

	/**
	 * delete user second controller
	 * @param user_id
	 * @param map
	 * @return
	 */
	@RequestMapping("/userDelDo")
	public String userDelDo(Integer user_id,Map<String, Object> map){
		userService.userDel(user_id, map);
		return "main/message";
	}

	/**
	 * delete multiple users
	 * @param ids
	 * @return
	 */
	@RequestMapping("/userDelAll")
	public String userDelAll(GetIds ids){
		userService.delAll(ids);
		return "main/message";
	}


	/**
	 * get user information
	 * @return
	 */
	@RequestMapping("/userInfor")
	public String userInfor(){
		return "user/userInfor";
	}
}
