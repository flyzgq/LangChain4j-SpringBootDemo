package com.example.langchain4j13search.service;

import com.example.langchain4j13search.service.ChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatAssistantTest {

    @Autowired
    private ChatAssistant assistant;
    @Test
    void chat() {
        String chat = assistant.chat("今天20241008 上证指数是多少？");
        System.out.println(chat);
    }
}