package com.example.langchain4j04streaming.config;

import com.example.langchain4j04streaming.service.ChatAssistant;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamConfig {


    @Bean
    public StreamingChatLanguageModel streamingChatLanguageModel(){
        return OpenAiStreamingChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_KEY"))
                .modelName("qwen-max")
                .logRequests(true)
                .logResponses(true)
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    @Bean
    public ChatAssistant chatAssistant(StreamingChatLanguageModel streamingChatLanguageModel){
        return AiServices.create(ChatAssistant.class, streamingChatLanguageModel);
    }
}
