package com.wujq.service;

import com.wujq.domain.User;

import java.util.Map;

public interface UserService {
	Map<String, Object> userList(Map<String, Object> map);
	Map<String, Object> userAdd(User user,Map<String, Object> map);
	User load(Integer user_id);
	Map<String, Object> userMdi(User user,Map<String, Object> map);
	Map<String, Object> userDel(Integer user_id,Map<String, Object> map);

}
