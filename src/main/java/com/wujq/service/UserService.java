package com.wujq.service;

import com.wujq.domain.User;
import com.wujq.util.GetIds;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {
	Map<String, Object> userList(Map<String, Object> map);
	Map<String, Object> userAdd(User user,Map<String, Object> map);
	User load(Integer user_id);
	Map<String, Object> userMdi(User user,Map<String, Object> map);
	Map<String, Object> userDel(Integer user_id,Map<String, Object> map);
	Map<String, Object> login(Map<String, Object> map, HttpServletRequest request);
	int delAll(GetIds ids);
}
