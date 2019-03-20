package com.lxp.LittleMusic.services;



import com.lxp.LittleMusic.models.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lxp.LittleMusic.controllers.UserMessageController;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;

@Component
public class LoginService {

    @Autowired
    private UserMessageController userMessageController;

    //登录账户是否合法/存在
    public boolean isValidate(String userName,String password){
        List<UserMessage> user= userMessageController.findLoginUser(userName,password);
        if(!user.isEmpty()) return true; //存在
        else return false;

    }



}
