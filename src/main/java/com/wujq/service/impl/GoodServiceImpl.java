package com.wujq.service.impl;

import com.wujq.domain.Good;
import com.wujq.mapper.GoodMapper;
import com.wujq.service.GoodService;
import com.wujq.util.GetIds;
import com.wujq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    /**
     * check goods
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> goodList(Map<String, Object> map) {
        List<Good> goodList = goodMapper.goodList(map);
        int count = goodMapper.count(map);
        PageBean.serMap(map, count, goodList, Good.class);
        return map;
    }

    /**
     * goods add
     * @param good
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> goodAdd(Good good, Map<String, Object> map) {
        int result = goodMapper.add(good);
        if(result>0){
            map.put("message", "successfully added");
        }else {
            map.put("message", "fail to add");
        }
        return map;
    }

    /**
     * goods load
     * @param good_id
     * @return
     */
    @Override
    public Good load(Integer good_id) {
        return goodMapper.load(good_id);
    }

    /**
     * goods modify
     * @param good
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> goodMdi(Good good, Map<String, Object> map) {
        int result = goodMapper.update(good);
        if(result>0){
            map.put("message", "successfully modified");
        }else {
            map.put("message", "fail to modify");
        }
        return map;
    }

    /**
     * goods delete
     * @param good_id
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> goodDel(Integer good_id, Map<String, Object> map) {
        int result = goodMapper.delete(good_id);
        if(result>0){
            map.put("message", "successfully deleted");
        }else {
            map.put("message", "fail to delete");
        }
        return map;
    }

    /**
     * multiple goods delete
     * @param ids
     * @return
     */
    @Override
    public int delAll(GetIds ids) {
        List list = ids.getIds();
        int result = goodMapper.delAll(list);
        return result;
    }
}
