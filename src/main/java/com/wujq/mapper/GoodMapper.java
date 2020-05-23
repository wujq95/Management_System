package com.wujq.mapper;

import com.wujq.domain.Good;
import com.wujq.domain.User;

import java.util.List;
import java.util.Map;

public interface GoodMapper {

    int delete(Integer good_id);

    int add(Good good);
    Good load(Integer good_id);
    int update(Good good);

    //查询商品列表
    List<Good> goodList(Map<String, Object> map);
    //查询数量
    int count(Map<String, Object> map);

    int delAll(List ids);
}
