package com.boot.controller;

import com.boot.pojo.User;
import com.boot.service.RecordService;
import com.boot.service.UserService;
import com.boot.utils.MD5;
import com.boot.utils.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by w-fy on 2017/1/23.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RecordService recordService;

    @RequestMapping("login")
    public String getAll(){
        return  "login";
    }

    @RequestMapping("User/index")
    public String getAll(ModelMap map){
        map.put("list",userService.getAll());
        return "User/index";
    }
    @RequestMapping("User/insert")
    public String insert(User u,ModelMap map,HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String pass= request.getParameter("password");
        u.setPassword(MD5.EncoderByMd5(pass));
        userService.insert(u);
        map.put("userList",recordService.getAll());
        return "User/list";
    }
    @RequestMapping("User/seach")
    public String seach(User user, HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        List<User> list=userService.getAll();
        String newname=request.getParameter("name");
        String newpass=request.getParameter("password");
        user=userService.getUser(user);
        if(user!=null){
            for(int i=0;i<list.size();i++){
                boolean bool= MD5.checkpassword(newpass,list.get(i).getPassword());
                if(list.get(i).getName().equals(newname)&&bool&&
                        list.get(i).getStatus()==1){
                    request.getSession().setAttribute("user",user);
                    int id=list.get(i).getId();
                    int status=list.get(i).getStatus();
                    request.getSession().setAttribute("status",status);
                    request.getSession().setAttribute("id",id);
                    map.put("recordList",recordService.getAllById(id));
                    return "Record/index";
                }else if(list.get(i).getName().equals(newname)&&bool&&
                        list.get(i).getStatus()==0){
                    request.getSession().setAttribute("user",user);
                    int id=list.get(i).getId();
                    int status=list.get(i).getStatus();
                    request.getSession().setAttribute("status",status);
                    request.getSession().setAttribute("id",id);
                    map.put("userList",recordService.getAll());
                    return "User/list";
                }
            } return "redirect:/login";
        }
        // System.out.println("list333");
        return "redirect:/login";
    }
    @RequestMapping(value="User/add")
    public String add(ModelMap map){
        map.put("status", Values.shenfen);
        return "User/edit";
    }

    @RequestMapping(value="User/edit",params="id" )
    public String getById(int id,ModelMap map){
        map.put("info",userService.getById(id));
        return "User/edit";
    }

}
