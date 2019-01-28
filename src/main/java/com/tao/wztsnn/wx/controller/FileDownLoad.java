package com.tao.wztsnn.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileDownLoad {
    @CrossOrigin
    //文件下载相关代码
    @RequestMapping("/download")
    @ResponseBody
    public String downloadFile(@RequestParam(name = "file") MultipartFile multipartFile, HttpServletResponse response) {

        String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase()+"."+multipartFile.getOriginalFilename().replaceFirst(".*\\.","");
        System.out.println("进入get方法！拿到文件:"+fileName);
        String realPath = "/home/wzt";
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file  =  new File(realPath,fileName);
            multipartFile.transferTo(file);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        return null;
    }
}
