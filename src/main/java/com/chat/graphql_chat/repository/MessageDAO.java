package com.chat.graphql_chat.repository;

import com.chat.graphql_chat.model.Messages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDAO extends MongoRepository<Messages,Long> {
    public List<Messages> findByUsernameOrderByDateDesc(String username);
}
