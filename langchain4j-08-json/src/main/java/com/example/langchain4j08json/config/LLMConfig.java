package com.example.langchain4j08json.config;

import com.example.langchain4j08json.service.NumberExtractor;
import com.example.langchain4j08json.service.PersonExtractor;
import com.example.langchain4j08json.service.SentimentAnalyzer;
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
                .modelName("qwen-turbo")
                .logRequests(true)
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    @Bean
    public NumberExtractor numberExtractor(ChatLanguageModel chatLanguageModel){
        return AiServices.create(NumberExtractor.class, chatLanguageModel);
    }


    @Bean
    public SentimentAnalyzer sentimentAnalyzer(ChatLanguageModel chatLanguageModel){
        return AiServices.create(SentimentAnalyzer.class, chatLanguageModel);
    }


    @Bean
    public PersonExtractor personExtractor(ChatLanguageModel chatLanguageModel){
        return AiServices.create(PersonExtractor.class, chatLanguageModel);
    }
}
