package com.lxp.LittleMusic.controllers;

import com.lxp.LittleMusic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @Autowired
    CountTimesService countTimesServicec;

    @GetMapping("/")
    public String test(Model model){

        //获取总访问量
        model.addAttribute("uname", "root");
        model.addAttribute("visitcount", countTimesServicec.getAllVisitors().toString());

        return "index";
    }

}
