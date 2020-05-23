package com.wujq.controller;

import com.wujq.domain.Good;
import com.wujq.domain.Type;
import com.wujq.service.GoodService;
import com.wujq.service.TypeService;
import com.wujq.util.GetIds;
import com.wujq.util.PageBean;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("/goodList")
    public String goodList(Map<String,Object> map, @RequestParam(required=false,defaultValue="1") int pages, @RequestParam(required=false,defaultValue="5") int num, Good good, HttpServletRequest request){
        PageBean.conMap(map, pages, num, request, Good.class);
        goodService.goodList(map);
        return "good/goodList";
    }

    @RequestMapping("/goodAdd")
    public String goodAdd(Map<String, Object> map){
        List<Type> typeAllList = typeService.typeAllList();
        map.put("typeAllList", typeAllList);
        return "good/goodAdd";
    }

    @RequestMapping("/goodAddDo")
    public String goodAddDo(Good good, Map<String, Object> map, HttpServletRequest request) throws IllegalStateException{
        goodService.goodAdd(good, map);
        return "main/message";
    }

    @RequestMapping("/goodMdi")
    public String goodMdi(Integer good_id,Map<String, Object> map){
        Good good = goodService.load(good_id);
        map.put("good", good);
        List<Type> typeAllList = typeService.typeAllList();
        map.put("typeAllList", typeAllList);
        return "good/goodMdi";
    }
    @RequestMapping("/goodMdiDo")
    public String goodMdiDo(Good good,Map<String, Object> map,HttpServletRequest request) throws IllegalStateException, IOException {
        goodService.goodMdi(good, map);
        return "main/message";
    }
    @RequestMapping("/goodDel")
    public String goodDel(Integer good_id,Map<String, Object> map){
        map.put("good_id", good_id);
        return "good/goodDel";
    }
    @RequestMapping("/goodDelDo")
    public String goodDelDo(Integer good_id,Map<String, Object> map){
        goodService.goodDel(good_id, map);
        return "main/message";
    }

    @RequestMapping("/goodDelAll")
    public String goodelAll(GetIds ids){
        goodService.delAll(ids);
        return "main/message";
    }
}
