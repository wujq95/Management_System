package com.wujq.controller;

import com.wujq.domain.User;
import com.wujq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    /**
     * jump to main page
     * @return
     */
    @RequestMapping("/main")
    public String main(){
        return "main/main";
    }

    /**
     * jump back to login page
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "redirect:/index.jsp";
    }

    /**
     * do the login action
     * @param user
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/loginDo")
    public String loginDo(User user, Map<String,Object> map, HttpServletRequest request){
        userService.login(map, request);
        return "main/"+map.get("url");
    }

    /**
     * logout controller
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/index.jsp";
    }

}
