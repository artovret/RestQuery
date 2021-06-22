package com.example.task3.repository;

import com.example.task3.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<Message,Long> {
    Message findTopByOrderByIdAsc();
    @Query(value = "select * from messages m order by length(m.msg) desc limit 1", nativeQuery = true)
    Message findTopOrderByMsgLength();
    //Message findTopById();
    //Message findFirstByIdOrderByPointPointsDesc(int userId)

}
