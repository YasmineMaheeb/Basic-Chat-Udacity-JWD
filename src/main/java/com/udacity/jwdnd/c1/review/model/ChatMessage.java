package com.udacity.jwdnd.c1.review.model;

import javax.annotation.PostConstruct;

public class ChatMessage {
    private String username, text;
    private int id;


    public String getText(){
        return text;
    }

    public String getUsername(){
        return username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }
}
