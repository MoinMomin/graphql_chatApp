package com.chat.graphql_chat.mapper;

import lombok.Data;

@Data
public class MessageMapper {
    private String userName;
    private int skip;
    private  int limit;
}
