package com.lxp.LittleMusic.controllers;

import com.lxp.LittleMusic.models.UserPlayerList;
import com.lxp.LittleMusic.models.UserPlayerListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserPlayerListControllor {
    @Autowired
    private UserPlayerListRepository userPlayerListRepository;

    //add,修改音乐列表
    //添加User
    public UserPlayerList addMusic(@RequestParam("userName") String userName,
                                   @RequestParam("mp3") String mp3,
                                   @RequestParam("oga") String oga,
                                   @RequestParam("title") String title,
                                   @RequestParam("artist") String artist,
                                   @RequestParam("rating") String rating,
                                   @RequestParam("buy") String buy,
                                   @RequestParam("price") String price,
                                   @RequestParam("duration") String duration,
                                   @RequestParam("cover") String cover
                                  ) {

        UserPlayerList upl = new UserPlayerList();
        upl.setUserName(userName);
        upl.setMp3(mp3);
        upl.setOga(oga);
        upl.setTitle(title);
        upl.setArtist(artist);
        upl.setBuy(buy);
        upl.setPrice(price);
        upl.setDuration(duration);
        upl.setCover(cover);
        upl.setRating(rating);

        return userPlayerListRepository.save(upl);
    }

    public List<UserPlayerList> FindUserList(String userName ){
        return userPlayerListRepository.findBy(userName);
    }

}
