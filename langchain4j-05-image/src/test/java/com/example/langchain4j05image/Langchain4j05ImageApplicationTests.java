package com.example.langchain4j05image;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Base64;

@SpringBootTest
class Langchain4j05ImageApplicationTests {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Value("1.png")
    private Resource resource;

    @Test
    void contextLoads() throws IOException {

        byte[] contentAsByteArray = resource.getContentAsByteArray();
        String encodeToString = Base64.getEncoder().encodeToString(contentAsByteArray);
        UserMessage userMessage = UserMessage.from(TextContent.from("从以下图片中获取 9.30号的上证指数"),
                ImageContent.from(encodeToString, "image/png"));
        Response<AiMessage> messageResponse = chatLanguageModel.generate(userMessage);
        System.out.println(messageResponse.content().text());
    }

}
