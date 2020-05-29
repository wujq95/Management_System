package com.wujq.mapper;

import com.wujq.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int delete(Integer user_id);
    int add(User user);
    User load(Integer user_id);
    int update(User user);
    List<User> userList(Map<String, Object> map);
    int count(Map<String, Object> map);
    User login(Map<String, Object> map);
    int delAll(List ids);
}