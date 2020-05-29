package com.wujq.mapper;

import com.wujq.domain.Good;

import java.util.List;
import java.util.Map;

public interface GoodMapper {

    int delete(Integer good_id);
    int add(Good good);
    Good load(Integer good_id);
    int update(Good good);
    List<Good> goodList(Map<String, Object> map);
    int count(Map<String, Object> map);
    int delAll(List ids);
}
