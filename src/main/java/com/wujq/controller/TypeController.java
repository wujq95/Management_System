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

    /**
     * check type controller
     * @param map
     * @param pages
     * @param num
     * @param type
     * @param request
     * @return
     */
    @RequestMapping("/typeList")
    public String typeList(Map<String,Object> map, @RequestParam(required=false,defaultValue="1") int pages, @RequestParam(required=false,defaultValue="5") int num, Type type, HttpServletRequest request){
        PageBean.conMap(map, pages, num, request, Type.class);
        typeService.typeList(map);
        return "type/typeList";
    }

    /**
     * add type first controller
     * @return
     */
    @RequestMapping("/typeAdd")
    public String typeAdd(){

        return "type/typeAdd";
    }

    /**
     * add type second controller
     * @param type
     * @param map
     * @return
     */
    @RequestMapping("/typeAddDo")
    public String typeAddDo(Type type,Map<String, Object> map) {
        typeService.typeAdd(type, map);
        return "main/message";
    }

    /**
     * modify type first controller
     * @param type_id
     * @param map
     * @return
     */
    @RequestMapping("/typeMdi")
    public String typeMdi(Integer type_id,Map<String, Object> map){
        Type type = typeService.load(type_id);
        map.put("type", type);
        return "type/typeMdi";
    }

    /**
     * modify type second controller
     * @param type
     * @param map
     * @return
     */
    @RequestMapping("/typeMdiDo")
    public String typeMdiDo(Type type, Map<String, Object> map) {
        typeService.typeMdi(type, map);
        return "main/message";
    }

    /**
     * delete type first controller
     * @param type_id
     * @param map
     * @return
     */
    @RequestMapping("/typeDel")
    public String typeDel(Integer type_id,Map<String, Object> map){
        map.put("type_id", type_id);
        return "type/typeDel";
    }

    /**
     * delete type second controller
     * @param type_id
     * @param map
     * @return
     */
    @RequestMapping("/typeDelDo")
    public String typeDelDo(Integer type_id,Map<String, Object> map){
        typeService.typeDel(type_id, map);
        return "main/message";
    }
}
