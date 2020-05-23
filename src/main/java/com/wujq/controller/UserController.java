package com.wujq.controller;

import com.wujq.domain.Role;
import com.wujq.service.RoleService;
import com.wujq.util.GetIds;
import com.wujq.util.PageBean;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wujq.domain.User;
import com.wujq.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@RequestMapping("/userList")
	public String userList(Map<String,Object> map,@RequestParam(required=false,defaultValue="1") int pages,@RequestParam(required=false,defaultValue="5") int num,User user,HttpServletRequest request){
		PageBean.conMap(map, pages, num, request, User.class);
		userService.userList(map);
		return "user/userList";
	}
	@RequestMapping("/userAdd")
	public String userAdd(Map<String, Object> map){
		List<Role> roleAllList = roleService.roleAllList();
		map.put("roleAllList", roleAllList);
		return "user/userAdd";
	}
	@RequestMapping("/userAddDo")
	public String userAddDo(User user,MultipartFile photo,Map<String, Object> map,HttpServletRequest request) throws IllegalStateException, IOException{
		if(photo!=null&&photo.getOriginalFilename()!=null&&photo.getOriginalFilename()!=""){

			//定义文件上传路径
			String path = request.getSession().getServletContext().getRealPath("upload");
			//获取文件名
			String realName = photo.getOriginalFilename();
			//获取后缀
			String ext = FilenameUtils.getExtension(realName);
			//生成新的文件名
			String newName = UUID.randomUUID().toString().replaceAll("-", "")+"."+ext;
			//建立一个空文件
			File targetFile = new File(path, newName);

			//将文件写入空文件
			photo.transferTo(targetFile);
			user.setUser_img(newName);
		}
		userService.userAdd(user, map);
		return "main/message";
	}
	@RequestMapping("/userMdi")
	public String userMdi(Integer user_id,Map<String, Object> map){
		User user = userService.load(user_id);
		map.put("user", user);
		List<Role> roleAllList = roleService.roleAllList();
		map.put("roleAllList", roleAllList);
		return "user/userMdi";
	}
	@RequestMapping("/userMdiDo")
	public String userMdiDo(User user,MultipartFile photo,Map<String, Object> map,HttpServletRequest request) throws IllegalStateException, IOException{
		if(photo!=null&&photo.getOriginalFilename()!=null&&photo.getOriginalFilename()!=""){
			//定义文件上传路径
			String path = request.getSession().getServletContext().getRealPath("upload");
			//获取文件名
			String realName = photo.getOriginalFilename();
			//获取后缀
			String ext = FilenameUtils.getExtension(realName);
			//生成新的文件名
			String newName = UUID.randomUUID().toString().replaceAll("-", "")+"."+ext;
			//建立一个空文件
			File targetFile = new File(path, newName);

			//将文件写入空文件
			photo.transferTo(targetFile);
			user.setUser_img(newName);
		}
		userService.userMdi(user, map);
		return "main/message";
	}
	@RequestMapping("/userDel")
	public String userDel(Integer user_id,Map<String, Object> map){
		map.put("user_id", user_id);
		return "user/userDel";
	}
	@RequestMapping("/userDelDo")
	public String userDelDo(Integer user_id,Map<String, Object> map){
		userService.userDel(user_id, map);
		return "main/message";
	}

	@RequestMapping("/userDelAll")
	public String userDelAll(GetIds ids){
		userService.delAll(ids);
		return "main/message";
	}
}
