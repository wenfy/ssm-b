package com.boot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by w-fy on 2017/2/13.
 */
@Controller
@RequestMapping("UploadFile")
public class UploadFileController {
    // 访问路径为：http://127.0.0.1:8080/file
    @RequestMapping("file")
    public String file() {
        return "Record/file";
    }

    /**
     * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        int ii = files.size();
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File("F:/trs-ssm/uploadFile/"+file.getOriginalFilename())));
                    String oldName = file.getOriginalFilename();
                    String startName = oldName.substring(0,oldName.lastIndexOf("."));
                    System.out.println(startName);
                    String endName = oldName.substring(oldName.lastIndexOf("."));
//                    UUID uuid = UUID.randomUUID();
//                    String newStartName = uuid.fromString(startName).toString();
//                    System.out.println(newStartName);
                    stream.write(bytes);
                    stream.close();
                    request.getSession().setAttribute("fileUrl"+i,new File("F:/trs-ssm/uploadFile/"+file.getOriginalFilename()));
                } catch (Exception e) {
                    stream = null;
                    String message = "";
                    message = "You failed to upload " + i + " => "
                            + e.getMessage();
                    request.getSession().setAttribute("i",i);
                    request.getSession().setAttribute("mes", message);
                    return "Record/edit";
                }
            } else {
                String message = "";
                message = "成功上传" + i + "文件";
                request.getSession().setAttribute("i",i);
                request.getSession().setAttribute("mes", message);
                return "Record/edit";
            }

        }
        String message = "";
        message = "上传成功";
        request.getSession().setAttribute("i",ii);
        request.getSession().setAttribute("mes", message);
       return "Record/edit";

    }
}
