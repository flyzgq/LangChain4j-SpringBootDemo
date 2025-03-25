package com.example.langchain4j04streaming;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Langchain4j04StreamingApplicationTests {

    @Autowired
    private StreamingChatLanguageModel streamingChatLanguageModel;
    @Test
    void contextLoads() throws InterruptedException {
        streamingChatLanguageModel.generate("讲个笑话", new StreamingResponseHandler<AiMessage>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
        Thread.sleep(20000);
    }
}
