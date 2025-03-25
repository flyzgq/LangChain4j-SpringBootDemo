package com.example.langchain4j02simple.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatAssistantTest {

    @Autowired
    private ChatAssistant assistant;
    @Test
    void chat() {
        String chat = assistant.chat("你好");
        System.out.println(chat);
    }
}