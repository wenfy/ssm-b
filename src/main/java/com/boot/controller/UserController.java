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

    /**
     * 访问login
     * @return
     */
    @RequestMapping("login")
    public String getAll(){

        return  "login";
    }

    @RequestMapping("User/index")
    public String getAll(ModelMap map){
        map.put("list",userService.getAll());
        return "User/index";
    }

    /**
     * 添加用户
     * @param u
     * @param map
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("User/insert")
    public String insert(User u,ModelMap map,HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String pass = request.getParameter("password");
        u.setPassword(MD5.EncoderByMd5(pass));
        userService.insert(u);
        map.put("userList",recordService.getAll());
        return "User/list";
    }

    /**
     * 登录功能
     * @param user
     * @param request
     * @param map
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("User/seach")
    public String seach(User user, HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        List<User> list=userService.getAll();
        String newName = request.getParameter("name");
        String newPass = request.getParameter("password");
        user = userService.getUser(user);
        if (user != null){
            for (int i = 0;i < list.size();i++){
                boolean bool = MD5.checkpassword(newPass,list.get(i).getPassword());
                if(list.get(i).getName().equals(newName)&&bool&&
                        list.get(i).getStatus() == 1){
                    request.getSession().setAttribute("user",user);
                    int id = list.get(i).getId();
                    int status = list.get(i).getStatus();
                    request.getSession().setAttribute("status",status);
                    request.getSession().setAttribute("id",id);
                    map.put("recordList",recordService.getAllById(id));
                    return "Record/index";
                }else if(list.get(i).getName().equals(newName)&&bool&&
                        list.get(i).getStatus() == 0){
                    request.getSession().setAttribute("user",user);
                    int id = list.get(i).getId();
                    int status = list.get(i).getStatus();
                    request.getSession().setAttribute("status",status);
                    request.getSession().setAttribute("id",id);
                    map.put("userList",recordService.getAll());
                    return "User/list";
                }
            } return "redirect:/login";
        }
        return "redirect:/login";
    }
    @RequestMapping(value = "User/add")
    public String add(ModelMap map){
        map.put("status", Values.shenfen);
        return "User/edit";
    }

    @RequestMapping(value = "User/edit",params = "id" )
    public String getById(int id,ModelMap map){
        map.put("info",userService.getById(id));
        return "User/edit";
    }

}
