package com.udacity.jwdnd.c1.review;

import javax.annotation.PostConstruct;

public class chatMessage {
    private String username, text;


    public String getText(){
        return text;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }
}
