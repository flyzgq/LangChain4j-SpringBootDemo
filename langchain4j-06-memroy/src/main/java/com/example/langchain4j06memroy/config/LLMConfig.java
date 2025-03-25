package com.example.langchain4j06memroy.config;

import com.example.langchain4j06memroy.service.ChatAssistant;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMConfig {

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_KEY"))
                .modelName("qwen-long")  // 设置使用的模型名称
                .logRequests(true)
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

//    @Bean
//    public ChatAssistant chatAssistant(ChatLanguageModel chatLanguageModel){
//        return AiServices.builder(ChatAssistant.class)
//                .chatLanguageModel(chatLanguageModel)
//                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
//                .build();
//    }

    @Bean
    public ChatAssistant chatAssistant(ChatLanguageModel chatLanguageModel){
        return AiServices.builder(ChatAssistant.class)
                .chatLanguageModel(chatLanguageModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }

}
