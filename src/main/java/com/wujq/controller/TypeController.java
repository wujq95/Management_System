package com.wujq.controller;

import com.wujq.domain.Type;
import com.wujq.service.TypeService;
import com.wujq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;
    @RequestMapping("/typeList")
    public String typeList(Map<String,Object> map, @RequestParam(required=false,defaultValue="1") int pages, @RequestParam(required=false,defaultValue="5") int num, Type type, HttpServletRequest request){
        PageBean.conMap(map, pages, num, request, Type.class);
        typeService.typeList(map);
        return "type/typeList";
    }
    @RequestMapping("/typeAdd")
    public String typeAdd(){

        return "type/typeAdd";
    }
    @RequestMapping("/typeAddDo")
    public String typeAddDo(Type type,Map<String, Object> map) {
        typeService.typeAdd(type, map);
        return "main/message";
    }
    @RequestMapping("/typeMdi")
    public String typeMdi(Integer type_id,Map<String, Object> map){
        Type type = typeService.load(type_id);
        map.put("type", type);
        return "type/typeMdi";
    }
    @RequestMapping("/typeMdiDo")
    public String typeMdiDo(Type type, Map<String, Object> map) {
        typeService.typeMdi(type, map);
        return "main/message";
    }
    @RequestMapping("/typeDel")
    public String typeDel(Integer type_id,Map<String, Object> map){
        map.put("type_id", type_id);
        return "type/typeDel";
    }
    @RequestMapping("/typeDelDo")
    public String typeDelDo(Integer type_id,Map<String, Object> map){
        typeService.typeDel(type_id, map);
        return "main/message";
    }
}
