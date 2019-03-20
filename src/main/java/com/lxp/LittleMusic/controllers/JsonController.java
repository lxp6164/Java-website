package com.lxp.LittleMusic.controllers;

import com.lxp.LittleMusic.models.UserPlayerList;
import com.lxp.LittleMusic.models.UserPlayerListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JsonController {
    @Autowired
    private UserPlayerListControllor userPlayerListControllor;
    @Autowired
    private UserPlayerListRepository userPlayerListRepository;

    /*
    public Map<String, Object> test(){
        Map m = new HashMap<>();
        m.put("t", "d");
        return m;
    }
*/
    @GetMapping("/json")
    public List<UserPlayerList> transformToJson(@RequestParam(value = "userName")String userName){
        return userPlayerListControllor.FindUserList(userName);

    }


}
