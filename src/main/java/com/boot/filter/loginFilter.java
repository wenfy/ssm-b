package com.boot.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
 class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginFilter()).addPathPatterns("/**");
        registry.addInterceptor(new loginFilter());
    }
}
public class loginFilter implements HandlerInterceptor{

    String matcher="/login,/User/seach";
    String matcher1=".js,.html,.css";
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpServletRequest req = httpServletRequest;
        HttpServletResponse resp = httpServletResponse;
        String name = req.getRequestURI();
        if (name.endsWith(".jsp")){
            String p = req.getContextPath();
            resp.sendRedirect(p+"/login");
            return false;
        }
        String hz = "";
        if (name.lastIndexOf('.') >= 0){
            hz = name.substring(name.lastIndexOf('.'),name.length());
        }
        if (matcher.indexOf(name) >=0 ||(matcher1.indexOf(hz) >= 0&&hz.length() > 0)){
            return  true;
        } else {
            if(req.getSession().getAttribute("user") != null){
                Object id=req.getSession().getAttribute("status");
                String idd = id+"";
                int idi=Integer.valueOf(idd);
               if (idi == 0){
                    return true;
               }
               else {
                   if (name.endsWith("User/add")){
                       String p=req.getContextPath();
                       resp.sendRedirect(p+"/login");
                       return false;
                   }else if (name.endsWith("Record/seach")){
                       String p = req.getContextPath();
                       resp.sendRedirect(p+"/login");
                       return false;
                   }else if (name.endsWith("Record/index2")){
                       String p = req.getContextPath();
                       resp.sendRedirect(p+"/login");
                       return false;
                   }else if (name.endsWith("User/insert")){
                       String p = req.getContextPath();
                       resp.sendRedirect(p+"/login");
                       return false;
                   }else {
                       return  true;}
               }
            }else{
                //没有登陆，转向登陆界面
                String p = req.getContextPath();
                resp.sendRedirect(p+"/login");
                return false;
            }
    }}

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
