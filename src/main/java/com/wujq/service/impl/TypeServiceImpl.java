package com.wujq.service.impl;

import com.wujq.domain.Type;
import com.wujq.mapper.TypeMapper;
import com.wujq.service.TypeService;
import com.wujq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * check type
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> typeList(Map<String, Object> map) {
        List<Type> typeList = typeMapper.typeList(map);
        int count = typeMapper.count(map);
        PageBean.serMap(map, count, typeList, Type.class);
        return map;
    }

    /**
     * type add
     * @param type
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> typeAdd(Type type, Map<String, Object> map) {
        int result = typeMapper.add(type);
        if(result>0){
            map.put("message", "successfully added");
        }else {
            map.put("message", "fail to add");
        }
        return map;
    }

    /**
     * type load
     * @param type_id
     * @return
     */
    @Override
    public Type load(Integer type_id) {
        return typeMapper.load(type_id);
    }

    /**
     * type modify
     * @param type
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> typeMdi(Type type, Map<String, Object> map) {
        int result = typeMapper.update(type);
        if(result>0){
            map.put("message", "successfully modified");
        }else {
            map.put("message", "fail to modify");
        }
        return map;
    }

    /**
     * type delete
     * @param type_id
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> typeDel(Integer type_id, Map<String, Object> map) {
        int result = typeMapper.delete(type_id);
        if(result>0){
            map.put("message", "successfully deleted");
        }else {
            map.put("message", "fail to delete");
        }
        return map;
    }

    /**
     * check multiple types
     * @return
     */
    @Override
    public List<Type> typeAllList() {
        return typeMapper.typeAllList();
    }

}
