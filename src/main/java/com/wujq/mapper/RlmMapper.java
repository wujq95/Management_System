package com.wujq.mapper;

import java.util.List;
import java.util.Map;

import com.wujq.domain.Rlm;

public interface RlmMapper {

    int delete(Integer rlm_id);

    int add(Rlm rlm);

    Rlm load(Integer rlm_id);

    int update(Rlm rlm);
    List<Rlm> havList(Integer role_id);
    int menuDel(Map<String, Object> map);
    int menuAdd(Map<String, Object> map);
}