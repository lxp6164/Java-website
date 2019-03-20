package com.lxp.LittleMusic.services;



import com.lxp.LittleMusic.models.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lxp.LittleMusic.controllers.UserMessageController;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;

@Component
public class RegisterService {

    @Autowired
    private UserMessageController userMessageController;

    //人数是否超过100
    public boolean isFull() {
        if (userMessageController.getCountUsers() >= 100) return true;
        else return false;
    }

    public boolean isExist(String userName) {
        List<UserMessage> user= userMessageController.findUser(userName);
        if(!user.isEmpty()) return true;
        else return false;
    }

    //注册
    public void register(String userName,String password){
        //获取原来的音乐数目,第一次注册肯定是0啊

        //List<User> user= userController.findUser(userName);
                                //取list中第一个元素
        //int musicCount = user.get(0).getMusicCount();
        UserMessage u = userMessageController.addUser(userName,password,0);

    }


}
