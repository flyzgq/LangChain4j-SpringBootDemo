package com.example.langchain4j03simple.config;

import com.example.langchain4j03simple.listener.MyChatModelListener;
import com.example.langchain4j03simple.service.ChatAssistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Configuration
public class LLMConfig {

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_KEY"))
                .modelName("qwen-turbo")
                .logRequests(true)
                .logResponses(true)
                .listeners(List.of(new MyChatModelListener()))
                .maxRetries(1)
                .timeout(Duration.ofSeconds(10))
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    @Bean
    public ChatAssistant chatAssistant(ChatLanguageModel chatLanguageModel){
        return AiServices.create(ChatAssistant.class, chatLanguageModel);
    }
}
