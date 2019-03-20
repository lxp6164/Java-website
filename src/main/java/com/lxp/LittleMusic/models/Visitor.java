package com.lxp.LittleMusic.models;

import javax.persistence.*;

@Entity
public class Visitor {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO)int id = 0;
    private String ip = "";
    private Long visitTime = 0L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Long visitTime) {
        this.visitTime = visitTime;
    }
}
