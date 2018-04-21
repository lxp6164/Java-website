package com.lxp.LittleMusic.models;

import javax.persistence.*;

@Entity
public class UserMessage {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO)int id = 0;
    private String userName = "";
    private String password = "";
    private int musicCount = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMusicCount() {
        return musicCount;
    }

    public void setMusicCount(int musicCount) {
        this.musicCount = musicCount;
    }
}
