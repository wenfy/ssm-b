package com.boot.controller;

import com.boot.pojo.Record;
import com.boot.service.RecordService;
import com.boot.service.UserService;
import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
@Controller
@RequestMapping("Record")
public class RecordController {
    @Autowired
    RecordService recordService;
    @Autowired
    UserService userService;

    @RequestMapping("index2")
    public String getAll2( ModelMap map){
        map.put("userList",recordService.getAll());
        return "User/list";
    }

    /**
     * 管理员根据员工姓名查日志
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("seach")
    public String seach (ModelMap map,HttpServletRequest request){
        String name=request.getParameter("username");
        if(name != "") {
            map.put("userList", recordService.getAllByName(name));
            return "User/list";
        }else {
            map.put("userList",recordService.getAll());
            return "User/list";

        }

    }

    /**
     * 员工登录
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String getAll( ModelMap map,HttpServletRequest request){
        Object id=request.getSession().getAttribute("id");
        String idd=id+"";
        int idi=Integer.valueOf(idd);
        map.put("recordList",recordService.getAllById(idi));
        return "Record/index";
    }

    /**
     * 员工编写日志
     * @param r
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("insert")
    public String insert(Record r, ModelMap map, HttpServletRequest request){
        Date now = new Date();
        String fileUrl3 = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        r.setData(dateFormat.format(now));
        Object id = request.getSession().getAttribute("id");
        String idd = id + "";
        int idi = Integer.valueOf(idd);
        r.setUserid(idi);
        Object filesSize =  request.getSession().getAttribute("i");
        String filesSize2 = filesSize + "";
        int fileSize = Integer.valueOf(filesSize2);
        System.out.println(fileSize);

        for (int i = 0 ;i < fileSize; i++){
            Object fileUrl =  request.getSession().getAttribute("fileUrl"+i);
          // request.getSession().setMaxInactiveInterval(5);
            String  fileUrl2 = fileUrl + "";
            fileUrl3 += fileUrl2 + ",";
            request.getSession().setAttribute("fileUrl"+i,"");
        }
        r.setFileUrl(fileUrl3);
        recordService.insert(r);

        getAll(map,request);
        return "Record/index";
    }

    /**
     * 修改日志
     * @param r
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("update")
    public String update(Record r,ModelMap map,HttpServletRequest request){
        Date now = new Date();
        String fileUrl3 = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        r.setData(dateFormat.format(now));
        recordService.update(r);
        getAll(map,request);
        return "Record/index";
    }
    @RequestMapping("delete")
    public String delete(int id,ModelMap map,HttpServletRequest request){
        recordService.delete(id);
        getAll(map,request);
        return "Record/index";
    }
    @RequestMapping(value = "add")
    public String add(ModelMap map){

        return "Record/edit";
    }

    @RequestMapping(value = "edit",params = "id")
    public String getId(int id,ModelMap map){
        map.put("info",recordService.getById(id));
        return "Record/edit";
    }

    /**
     * 查看内容
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "look",params = "id")
    public String getComments(int id,ModelMap map,HttpServletRequest request) throws Exception{
        String fileUrl = recordService.getFileUrlById(id);
        String[] splitFileUrl = fileUrl.split("\\,");
        String st = "";
        String str="";
        String[] nameList=new String[splitFileUrl.length];
        for(int i=0;i<splitFileUrl.length;i++) {
            String fileName =  splitFileUrl[i].substring(splitFileUrl[i].lastIndexOf("\\")+1);
            nameList[i]=fileName;
        }
        map.put("nameList",nameList);
        map.put("cList",recordService.getCommentsById(id));
        Object id1=request.getSession().getAttribute("status");
        String idd = id1+"";
        int idi=Integer.valueOf(idd);
        if ( idi == 0){
            return "User/cList";
        }else{
        return "Record/cList";
        }
    }

    @RequestMapping(value = "urlSearch",params = "fileUrl")
    public String urlSearch(String fileUrl,ModelMap map)throws Exception{
       List<String> urlList = recordService.getFileUrl(fileUrl);
        String st = "";
        String strR = "";
       for (String str:urlList){
           System.out.println(str);
           String[] splitFileUrl = str.split("\\,");
               for(String s : splitFileUrl){
                   if(s.indexOf(fileUrl)>0){
                       File file = new File(s);
            FileReader fileReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fileReader);
            String tempString = null;
            while ( (tempString = bReader.readLine()) != null ) {
                strR += tempString + "\n";
                map.put("fileList",strR);
            }
            bReader.close();
            fileReader.close();
                       return "Record/fileList";
        }
                   }
           }
       return null;
    }


    }

