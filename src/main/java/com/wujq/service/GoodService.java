package com.wujq.service;

import com.wujq.domain.Good;
import com.wujq.util.GetIds;

import java.util.Map;

public interface GoodService {

    Map<String, Object> goodList(Map<String, Object> map);
    Map<String, Object> goodAdd(Good good, Map<String, Object> map);
    Good load(Integer good_id);
    Map<String, Object> goodMdi(Good good,Map<String, Object> map);
    Map<String, Object> goodDel(Integer good_id,Map<String, Object> map);
    int delAll(GetIds ids);
}
