package com.lxp.LittleMusic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    MainController(){
        super();
        System.out.println("MainController");
    }

    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("message", "I am Ok");
        return "index";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
