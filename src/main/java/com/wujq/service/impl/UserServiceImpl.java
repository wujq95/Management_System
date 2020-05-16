package com.wujq.service.impl;

import com.wujq.domain.User;
import com.wujq.mapper.UserMapper;
import com.wujq.service.UserService;
import com.wujq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public Map<String, Object> userList(Map<String, Object> map) {
        List<User> userList = userMapper.userList(map);
        int count = userMapper.count(map);
        PageBean.serMap(map, count, userList, User.class);
        return map;
    }
    @Override
    public Map<String, Object> userAdd(User user, Map<String, Object> map) {
        int result = userMapper.add(user);
        if(result>0){
            map.put("message", "添加成功");
        }else {
            map.put("message", "添加失败");
        }
        return map;
    }
    @Override
    public User load(Integer user_id) {
        return userMapper.load(user_id);
    }
    @Override
    public Map<String, Object> userMdi(User user, Map<String, Object> map) {
        int result = userMapper.update(user);
        if(result>0){
            map.put("message", "修改成功");
        }else {
            map.put("message", "修改失败");
        }
        return map;
    }
    @Override
    public Map<String, Object> userDel(Integer user_id, Map<String, Object> map) {
        int result = userMapper.delete(user_id);
        if(result>0){
            map.put("message", "删除成功");
        }else {
            map.put("message", "删除失败");
        }
        return map;
    }
}
