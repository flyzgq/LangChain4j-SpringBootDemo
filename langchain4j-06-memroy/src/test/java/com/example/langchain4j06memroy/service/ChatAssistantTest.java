package com.example.langchain4j06memroy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatAssistantTest {

    @Autowired
    private ChatAssistant chatAssistant;
    @Test
    void chat() {
        String chat = chatAssistant.chat("你好 我的名字是冷冷");

        System.out.println(chat);


        chat = chatAssistant.chat("你好 我的名字是什么？");

        System.out.println(chat);

    }

    @Test
    void chat2() {
        chatAssistant.chat(1L, "你好！我的名字是冷冷1.");
        chatAssistant.chat(2L, "你好！我的名字是冷冷2.");

        String chat = chatAssistant.chat(1L, "我的名字是什么");
        System.out.println(chat);
        chat = chatAssistant.chat(2L, "我的名字是什么");
        System.out.println(chat);

    }
}