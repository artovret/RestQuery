package com.example.task3.service;

import com.example.task3.model.Message;

import java.util.List;

public interface MessageService {

    Message offer(String message);

    Message poll();

    Message peek();

    Message peekMax();

    List<Message> all();

}
