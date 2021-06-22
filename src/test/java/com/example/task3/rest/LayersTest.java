package com.example.task3.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LayersTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGettingAllMessages() throws Exception {
        mockMvc.perform(get("/all")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("messages.public> insert into messages (msg) values")));
    }

    @Test
    public void testPeek() throws Exception {
        mockMvc.perform(get("/peek")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("any first message")));
    }

    @Test
    public void testPeekMax() throws Exception {
        mockMvc.perform(get("/peekmax")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Shutting down ExecutorService 'applicationTaskExecutor")));
    }

    @Test
    public void testPollFirst() throws Exception {
        mockMvc.perform(get("/poll")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("any first message")));
    }

    @Test
    public void testPollSecond() throws Exception {
        mockMvc.perform(get("/poll")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("messages.public> insert into messages (msg) values")));
    }



}
