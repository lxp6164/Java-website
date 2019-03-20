package com.lxp.LittleMusic.services;

import com.lxp.LittleMusic.models.Visitor;
import com.lxp.LittleMusic.models.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainService {

    @Autowired private VisitorRepository visitorRepository;

    public List<Visitor> getVisitors(){

        return visitorRepository.findAll();

    }
}
