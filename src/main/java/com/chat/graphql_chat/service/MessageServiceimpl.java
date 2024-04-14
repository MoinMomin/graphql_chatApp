package com.chat.graphql_chat.service;

import com.chat.graphql_chat.mapper.MessageMapper;
import com.chat.graphql_chat.model.Messages;
import com.chat.graphql_chat.repository.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceimpl implements MessageService {
    @Autowired
    MessageDAO chatDAO;
    @Override
    public Messages createChat(Messages chat) {
        return chatDAO.save(chat);
    }

    @Override
    public List<Messages> getChatByUserName(MessageMapper chatMapper) {
        Pageable pageable = PageRequest.of(chatMapper.getPage(), chatMapper.getSize());
       // return chatDAO.findByUsernameByDateDesc(chatMapper.getUserName(),pageable);
       return chatDAO.findByUsernameOrderByDateDesc(chatMapper.getUserName());

      //   return chatDAO.findByUsernameOrderByDateDesc(chatMapper.getUserName(),pageable);
    }

    @Override
    public List<Messages> getAllMesages() {
        return chatDAO.findAll();
    }
}
