package com.wujq.controller;

import com.wujq.domain.User;
import com.wujq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/main")
    public String main(){
        return "main/main";
    }

    @RequestMapping("/login")
    public String login(){
        return "redirect:/index.jsp";
    }

    @RequestMapping("/loginDo")
    public String loginDo(User user, Map<String,Object> map, HttpServletRequest request){
        userService.login(map, request);
        return "main/"+map.get("url");
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/index.jsp";
    }

}
