package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class MessageService {
    private ArrayList<ChatMessage> list;

    @PostConstruct
    public void postConstruct(){
        list = new ArrayList<>();
    }

    public void addChatMessage(ChatForm msg){

        ChatMessage cMsg = new ChatMessage();
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

    public ArrayList<ChatMessage> getMessages(){
        return this.list;
    }
}
