package com.example.task3.dto;

import com.example.task3.model.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private String message;


    public static MessageDto fromMessage(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(message.getMessage());
        return messageDto;
    }
}
