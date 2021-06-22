package com.example.task3.service.Impl;

import com.example.task3.model.Message;
import com.example.task3.repository.MessageRepository;
import com.example.task3.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message offer(String msg) {
        Message message = new Message();
        message.setMessage(msg);
        messageRepository.save(message);
        return message;
    }

    @Override
    public Message poll() {
        log.warn("poll()");
        Message message = messageRepository.findTopByOrderByIdAsc();
        messageRepository.delete(message);
        return message;
    }

    @Override
    public Message peek() {
        log.warn("peek()");
        return messageRepository.findTopByOrderByIdAsc();
    }

    @Override
    public Message peekMax() {
        log.warn("peekMax()");
        return messageRepository.findTopOrderByMsgLength();
        //return null;
    }

    @Override
    public List<Message> all() {
        return messageRepository.findAll();
    }
}
