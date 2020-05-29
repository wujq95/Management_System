package com.wujq.mapper;

import com.wujq.domain.Type;

import java.util.List;
import java.util.Map;

public interface TypeMapper {

    int delete(Integer type_id);
    int add(Type type);
    Type load(Integer type_id);
    int update(Type type);
    List<Type> typeList(Map<String, Object> map);
    int count(Map<String, Object> map);
    List<Type> typeAllList();
}
