package com.example.task3.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "msg")
    private String message;
}


