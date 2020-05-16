package com.wujq.mapper;

import com.wujq.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int delete(Integer user_id);

    int add(User user);

    User load(Integer user_id);

    int update(User user);
    //查询员工列表
    List<User> userList(Map<String, Object> map);
    //查询数量
    int count(Map<String, Object> map);
}