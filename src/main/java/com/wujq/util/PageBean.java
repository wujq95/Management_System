package com.wujq.util;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class PageBean {

    public static void conMap(Map<String, Object> map,int pages,int num,HttpServletRequest request,Object clazz){
        String name = clazz.getClass().getSimpleName().toLowerCase();
        map.put(name, clazz);
        map.put("pages", pages);
        map.put("num", num);
        map.put("beg", (pages-1)*num);
        map.put("url", request.getServletPath().substring(1));
    }
    public static void serMap(Map<String, Object> map, int count, List<?> list, Class<?> clazz){
        String name = clazz.getSimpleName().toLowerCase();
        int num = Integer.parseInt(map.get("num").toString());
        int sumPage = (count%num==0)?(count/num):(count/num+1);
        map.put(name+"List", list);
        map.put("count", count);
        map.put("sumPage", sumPage);
    }
}
