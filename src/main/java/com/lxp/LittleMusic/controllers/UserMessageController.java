package com.lxp.LittleMusic.controllers;

import com.lxp.LittleMusic.models.UserMessage;
import com.lxp.LittleMusic.models.UserMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserMessageController {
    @Autowired
    private UserMessageRepository userMessageRepository;

    //获取之前所有users数量
    public Long getCountUsers() {
        return userMessageRepository.count();
    }

    //提取该user
    public List<UserMessage> findUser(String userName) {
        return userMessageRepository.findBy(userName);
    }

    //查询user是否存在，合法
    public List<UserMessage> findLoginUser(String userName,String password) {
        return userMessageRepository.findBy(userName,password);
    }

    //添加User
    public UserMessage addUser(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("musicCount")int musicCount) {
        UserMessage u = new UserMessage();
        u.setUserName(userName);
        u.setPassword(password);
        u.setMusicCount(musicCount);

        return userMessageRepository.save(u);
    }
}

