package com.wujq.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            return true;
        }else{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out =response.getWriter();
            out.print("<script>alert('please login in');window.location.href='login';</script>");
            out.flush();
            out.close();
        }
        return false;
    }
}
