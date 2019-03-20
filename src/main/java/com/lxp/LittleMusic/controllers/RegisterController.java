package com.lxp.LittleMusic.controllers;

import com.lxp.LittleMusic.services.CountTimesService;
import com.lxp.LittleMusic.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;
    @Autowired
    HttpServletRequest httpServletRequest;
    //这里是说明每次进入这个页面时将触发这个控制器
    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})

    public String Register(@RequestParam(value = "userName", required = false)@Nullable String userName, @RequestParam(value = "password", required = false)@Nullable String password, Model model) {
        //model.addAttribute("userName", userName); //向前传
        //读取userName,password，是前台通过函数参数传过来的里的

        if("POST".equals(httpServletRequest.getMethod())){  //POST,从注册页面提交来的数据
            String str = "";
            //判断人数是否超过100
            if (registerService.isFull()) {         //超过100，不予注册，并警告
                //model.addAttribute("uname", "RegisterCountFull");
                str = "RegisterCountFull";
            }else if(registerService.isExist(userName)) {
                str = "TheUserNameisExist";
            }else {   //否，注册
                registerService.register(userName,password);
                str = userName;
            }
            //然而model.addAttribute的参数并没有传过来
            //这里用重定向更好

            String url = "uname="+str;
            return "redirect:/?"+url;
        }

        //GET,首次进入界面,读取页面而来的数据
        return "register";

    }


}


