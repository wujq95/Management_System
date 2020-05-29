package com.wujq.service;

import com.wujq.domain.Type;

import java.util.List;
import java.util.Map;

public interface TypeService {
    Map<String, Object> typeList(Map<String, Object> map);
    Map<String, Object> typeAdd(Type type, Map<String, Object> map);
    Type load(Integer type_id);
    Map<String, Object> typeMdi(Type type,Map<String, Object> map);
    Map<String, Object> typeDel(Integer type_id,Map<String, Object> map);
    List<Type> typeAllList();
}
