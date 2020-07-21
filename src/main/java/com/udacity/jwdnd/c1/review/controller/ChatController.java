package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.service.MessageService;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/chat")
    public String getHomePage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        model.addAttribute("greetings", this.messageService.getMessages());
        System.out.println("GET");
        return "chat";
    }

    @PostMapping("/chat")
    public String addMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        chatForm.setUsername(username);
        messageService.addChatMessage(chatForm);
        System.out.println("chatForm: "+chatForm.getText());
        model.addAttribute("greetings", messageService.getMessages());
        chatForm.setText("");
        chatForm.setUsername("");
        chatForm.setType(0);
        System.out.println("POST");
        return "chat";
    }
}
