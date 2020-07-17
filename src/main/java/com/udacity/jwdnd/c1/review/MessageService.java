package com.udacity.jwdnd.c1.review;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class MessageService {
    private ArrayList<chatMessage> list;

    @PostConstruct
    public void postConstruct(){
        list = new ArrayList<>();
    }

    public void addChatMessage(chatForm msg){
        chatMessage cMsg = new chatMessage();
        cMsg.setUsername(msg.getUsername());
        String text = msg.getText();
        System.out.println(text);
        if(msg.getType() == 1)
            text = text.toUpperCase();
        if(msg.getType() == 2)
            text = text.toLowerCase();
        cMsg.setText(text);
        list.add(cMsg);
    }

    public ArrayList<chatMessage> getMessages(){
        return this.list;
    }
}
