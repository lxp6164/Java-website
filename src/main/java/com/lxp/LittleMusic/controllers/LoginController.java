package com.lxp.LittleMusic.controllers;

import com.lxp.LittleMusic.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@RequestParam(value = "userName", required = false)@Nullable String userName, @RequestParam(value = "password", required = false)@Nullable String password, Model model) {
       // model.addAttribute("uname", userName);

        if("POST".equals(httpServletRequest.getMethod())) {  //POST,从注册页面提交来的数据
           String str = "";
           if(loginService.isValidate(userName,password)){   //存在,验证成功
               str = userName;

           }else { str = "LoginError"; }

           String url = "uname="+str;
           return "redirect:/?"+url;
        }

        return "login";

    }

}
