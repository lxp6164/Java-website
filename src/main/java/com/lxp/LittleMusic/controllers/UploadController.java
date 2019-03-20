package com.lxp.LittleMusic.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lxp.LittleMusic.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {
    @Autowired
    private UserPlayerListControllor userPlayerListControllor;
    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    HttpServletRequest httpServletRequest;
    @Value("${web.upload-path}/")
    private String filePath;
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String batchUpload() {
        return "upload";
    }


    @RequestMapping(value = "/upload",method = RequestMethod.POST)

    public  String uploadFile(@RequestParam("file") MultipartFile[] files,
                             @RequestParam("uname") String uname,
                             @RequestParam("title") String title,
                             @RequestParam("artist") String artist,
                             @RequestParam("duration") String duration,
                             HttpServletRequest request,
                             Model model) {
        //String str = uname;

        for(MultipartFile file : files) {
            if (file.isEmpty()) {
                model.addAttribute("message", "FailNull");
                return "upload";
            }
        }

        if(title==""||artist==""||duration==""){
            model.addAttribute("message", "FailNull");
            return "upload";

        }

        //判断该用户音乐是否超过10首,这个之后再做
        if(uploadFileService.isMusicListFull(uname)){
            model.addAttribute("message", "FailFull");
            return "upload";

        }

        String filename[] = new String[3];
        int cnt = 0;
        for(MultipartFile file : files){
            //上传3个文件
            String contentType1 = file.getContentType();
            String fileName = file.getOriginalFilename();
            filename[cnt++] = fileName;

            try {
                uploadFileService.uploadFile(file.getBytes(), filePath, fileName);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        //保存入数据库
        String price = "own";
        String rating = "3";
        userPlayerListControllor.addMusic(uname,filename[0],filename[1],title,artist,
                rating,filename[0],price,duration,filename[2]);

        //如何根据该用户数据库中的音乐列表  这张表 生成一个类似Json的变量并传送到index界面
        //index界面要根据该变量加载 音乐列表

        //返回json
        //思考之后,现在使用Ajax直接请求/json,再用Controller去数据库取得数据返回Json

        return "redirect:/?uname="+uname;
    }



}