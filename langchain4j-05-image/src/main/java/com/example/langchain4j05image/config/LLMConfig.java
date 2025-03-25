package com.example.langchain4j05image.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class LLMConfig {

    @Bean
    public ChatLanguageModel chatLanguageModel(){
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_KEY"))
                .modelName("qwen-vl-max")
                .logRequests(true)
                .logResponses(true)
                .timeout(Duration.ofSeconds(10))
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }
}
