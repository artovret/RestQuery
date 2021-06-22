package com.example.task3.rest;

import com.example.task3.dto.MessageDto;
import com.example.task3.model.Message;
import com.example.task3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//
//(поля: id – integer, msg – сообщение, 4к символов) (методы
//        offer – положить элемент,
//        poll – изъять и вернуть элемент, находящийся в начале очереди,
//        peek – возвращает первый элемент находящийся в начале очереди без изъятия,
//        peekMax – возвращает максимальный элемент в очереди,
//        all – список элементов в очереди, порядок как в очереди).

@RestController
@RequestMapping
public class OutputRestController {
    private final MessageService messageService;

    @Autowired
    public OutputRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("{request}")
    public ResponseEntity<MessageDto> getFromMessages(@PathVariable(name = "request") String request) {
        switch (request) {
            case "poll":
                return new ResponseEntity<>(MessageDto.fromMessage(messageService.poll()), HttpStatus.OK);
            case "peek":
                return new ResponseEntity<>(MessageDto.fromMessage(messageService.peek()), HttpStatus.OK);
            case "peekMax":
                return new ResponseEntity<>(MessageDto.fromMessage(messageService.peekMax()), HttpStatus.OK);
            case "all":
                Map<Object,Object> response = new HashMap<>();
                messageService.all().forEach(message -> response.put(message.getId(),message.getMessage()));
                return new ResponseEntity(response, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
