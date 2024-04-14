package com.chat.graphql_chat.controller;

import com.chat.graphql_chat.mapper.MessageMapper;
import com.chat.graphql_chat.model.Messages;
import com.chat.graphql_chat.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class MessageController {
    @Autowired
    MessageService chatService;
    @QueryMapping
    public List<Messages> getmessagebyusername(@Argument String username, @Argument int page, @Argument int size) {
        MessageMapper chatMapper=new MessageMapper();
        chatMapper.setUserName(username);
        chatMapper.setPage(page);
        chatMapper.setSize(size);
        return chatService.getChatByUserName(chatMapper);
    }

   /* @SchemaMapping()
    public List<Messages> messsages() {
        return chatService.getAllMesages();
    }*/
    @MutationMapping()
    public Messages createmessages(@Argument String username , @Argument String message) {
        log.info("createmessages mutation execute--");
        Messages messages=new Messages();
        messages.setUsername(username);
        messages.setMessage(message);
     return chatService.createChat(messages);
    }
}
