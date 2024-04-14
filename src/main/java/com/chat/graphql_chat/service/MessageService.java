package com.chat.graphql_chat.service;


import com.chat.graphql_chat.mapper.MessageMapper;
import com.chat.graphql_chat.model.Messages;

import java.util.List;

public interface MessageService {
    public Messages createChat(Messages chat);
    public List<Messages> getChatByUserName(MessageMapper chatMapper);
    public List<Messages> getAllMesages();
}
