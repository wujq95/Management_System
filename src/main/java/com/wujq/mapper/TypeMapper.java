package com.wujq.mapper;

import com.wujq.domain.Role;
import com.wujq.domain.Type;

import java.util.List;
import java.util.Map;

public interface TypeMapper {

    int delete(Integer type_id);
    int add(Type type);
    Type load(Integer type_id);
    int update(Type type);
    //查询角色列表
    List<Type> typeList(Map<String, Object> map);
    //查询数量
    int count(Map<String, Object> map);
    //查询角色列表
    List<Type> typeAllList();

}
