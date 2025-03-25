package com.example.langchain4j12graalvm.service;

import com.example.langchain4j12graalvm.service.ChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatAssistantTest {

    @Autowired
    private ChatAssistant assistant;
    @Test
    void chat() {
        String chat = assistant.chat("What is the square root of 485906798473894056 in scientific notation?");
        System.out.println(chat);
    }
}