package com.wujq.service.impl;

import com.wujq.domain.Good;
import com.wujq.domain.User;
import com.wujq.mapper.GoodMapper;
import com.wujq.mapper.MenuMapper;
import com.wujq.mapper.RlmMapper;
import com.wujq.mapper.UserMapper;
import com.wujq.service.GoodService;
import com.wujq.util.GetIds;
import com.wujq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private RlmMapper rlmMapper;
    @Autowired
    private MenuMapper menuMapper;


    @Override
    public Map<String, Object> goodList(Map<String, Object> map) {
        List<Good> goodList = goodMapper.goodList(map);
        int count = goodMapper.count(map);
        PageBean.serMap(map, count, goodList, Good.class);
        return map;
    }

    @Override
    public Map<String, Object> goodAdd(Good good, Map<String, Object> map) {
        int result = goodMapper.add(good);
        if(result>0){
            map.put("message", "添加成功");
        }else {
            map.put("message", "添加失败");
        }
        return map;
    }

    @Override
    public Good load(Integer good_id) {
        return goodMapper.load(good_id);
    }

    @Override
    public Map<String, Object> goodMdi(Good good, Map<String, Object> map) {
        int result = goodMapper.update(good);
        if(result>0){
            map.put("message", "修改成功");
        }else {
            map.put("message", "修改失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> goodDel(Integer good_id, Map<String, Object> map) {
        int result = goodMapper.delete(good_id);
        if(result>0){
            map.put("message", "删除成功");
        }else {
            map.put("message", "删除失败");
        }
        return map;
    }

    @Override
    public int delAll(GetIds ids) {
        List list = ids.getIds();
        int result = goodMapper.delAll(list);
        return result;
    }
}
