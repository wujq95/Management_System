package com.wujq.mapper;

import java.util.List;
import java.util.Map;

import com.wujq.domain.Role;

public interface RoleMapper {

    int delete(Integer role_id);
    int add(Role role);
    Role load(Integer role_id);
    int update(Role role);
    List<Role> roleList(Map<String, Object> map);
    int count(Map<String, Object> map);
    List<Role> roleAllList();
}