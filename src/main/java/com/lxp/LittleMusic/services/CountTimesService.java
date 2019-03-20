package com.lxp.LittleMusic.services;

import com.lxp.LittleMusic.controllers.VisitorCotroller;
import com.lxp.LittleMusic.models.Visitor;
import com.lxp.LittleMusic.models.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lxp.LittleMusic.controllers.VisitorCotroller;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;

@Component
public class CountTimesService {

    @Autowired private WebUtils webUtils;
    @Autowired private VisitorCotroller visitorCotroller;



    public Long getAllVisitors(){
        //获取之前所有visotors数量

        //获取当前访客id，可以直接存ip么？
        String clientip = webUtils.getClientIp();
        Long currentttime = webUtils.getCurrenttTime();
        //System.out.println(clientip);

        //访问数据库，看有没有该ip
        List<Visitor> vistorExist =  visitorCotroller.findVistors(clientip);//visitorRepository.findBy(clientip);

        //有,cnt不变

        //没有,将该ip加入数据库,cnt+1
        if(vistorExist.isEmpty()){
            //ip,visitTime
            visitorCotroller.addVisitor(clientip,currentttime);
        }
        return visitorCotroller.getCountVistors();
    }


}
