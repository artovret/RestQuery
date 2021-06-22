package com.example.task3.rest;


import com.example.task3.dto.MessageDto;
import com.example.task3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/offer")
public class InputRestController {
    private final MessageService messageService;

    @Autowired
    public InputRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity addMessage(@RequestBody MessageDto messageDto) {
        Map<Object, Object> response = new HashMap<>();
        response.put("message", messageService.offer(messageDto.getMessage()));
        return ResponseEntity.ok(response);
    }
}
