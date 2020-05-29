package com.wujq.mapper;

import java.util.List;

import com.wujq.domain.Menu;

public interface MenuMapper {

    int delete(Integer menu_id);
    int add(Menu menu);
    Menu load(Integer menu_id);
    int update(Menu menu);
    List<Menu> noList(Integer role_id);
    List<Menu> fatherList(Integer role_id);
}