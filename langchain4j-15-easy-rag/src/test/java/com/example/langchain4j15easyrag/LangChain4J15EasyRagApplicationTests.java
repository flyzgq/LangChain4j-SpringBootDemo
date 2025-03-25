package com.example.langchain4j15easyrag;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LangChain4J15EasyRagApplicationTests {
    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Test
    void contextLoads() {
        String generate = chatLanguageModel.generate("你好");

        System.out.println(generate);
    }

}
