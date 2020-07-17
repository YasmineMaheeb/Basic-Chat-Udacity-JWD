package com.udacity.jwdnd.c1.review.model;

import javax.annotation.PostConstruct;

public class chatForm {
     int type;
     String username;
     String text;

    public void setType(int type) {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public String getUsername(){
        return username;
    }

    public int getType() {
        return type;
    }
}
