package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ChatMessageMapper {
    @Select("SELECT * FROM MESSAGES")
    ArrayList<ChatMessage> getChatMessages();

    @Insert("INSERT INTO MESSAGES (username, text) VALUES(#{username}, #{text})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(ChatMessage chatMessage);
}
