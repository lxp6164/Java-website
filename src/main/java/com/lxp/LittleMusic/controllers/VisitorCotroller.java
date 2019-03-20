package com.lxp.LittleMusic.controllers;

import com.lxp.LittleMusic.models.Visitor;
import com.lxp.LittleMusic.models.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class VisitorCotroller {
    @Autowired
    private VisitorRepository visitorRepository;

    //获取之前所有visitors数量
    public Long getCountVistors() {
        return visitorRepository.count();
    }
    //查询表中是否存在该visitor
    public List<Visitor> findVistors(String ip)
    {
        return visitorRepository.findBy(ip);
    }

    //添加visitor
    public Visitor addVisitor(@RequestParam("ip")String ip,@RequestParam("visitTime")Long visitTime){
        Visitor v = new Visitor();
        v.setIp(ip);
        v.setVisitTime(visitTime);

        return visitorRepository.save(v);


    }

}
