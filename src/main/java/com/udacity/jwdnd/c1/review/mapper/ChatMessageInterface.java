package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChatMessageInterface {
    @Select("SELECT * FROM MESSAGES")
    ChatMessage getChatMessages();

    @Insert("INSERT INTO MESSAGES (username, text) VALUES(#{username}, #{text})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(ChatMessage chatMessage);
}
