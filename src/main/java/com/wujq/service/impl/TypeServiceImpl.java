package com.wujq.service.impl;

import com.wujq.domain.Menu;
import com.wujq.domain.Rlm;
import com.wujq.domain.Role;
import com.wujq.domain.Type;
import com.wujq.mapper.MenuMapper;
import com.wujq.mapper.RlmMapper;
import com.wujq.mapper.RoleMapper;
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
    @Autowired
    private RlmMapper rlmMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Map<String, Object> typeList(Map<String, Object> map) {
        List<Type> typeList = typeMapper.typeList(map);
        int count = typeMapper.count(map);
        PageBean.serMap(map, count, typeList, Type.class);
        return map;
    }

    @Override
    public Map<String, Object> typeAdd(Type type, Map<String, Object> map) {
        int result = typeMapper.add(type);
        if(result>0){
            map.put("message", "添加成功");
        }else {
            map.put("message", "添加失败");
        }
        return map;
    }

    @Override
    public Type load(Integer type_id) {
        return typeMapper.load(type_id);
    }

    @Override
    public Map<String, Object> typeMdi(Type type, Map<String, Object> map) {
        int result = typeMapper.update(type);
        if(result>0){
            map.put("message", "修改成功");
        }else {
            map.put("message", "修改失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> typeDel(Integer type_id, Map<String, Object> map) {
        int result = typeMapper.delete(type_id);
        if(result>0){
            map.put("message", "删除成功");
        }else {
            map.put("message", "删除失败");
        }
        return map;
    }

    @Override
    public List<Type> typeAllList() {
        return typeMapper.typeAllList();
    }

}
