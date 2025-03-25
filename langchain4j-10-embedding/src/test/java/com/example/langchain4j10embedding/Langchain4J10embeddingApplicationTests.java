package com.example.langchain4j10embedding;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Langchain4J10embeddingApplicationTests {
    @Autowired
    private EmbeddingModel embeddingModel;

    @Test
    void contextLoads() {
        Response<Embedding> embeddingResponse = embeddingModel.embed("测试文本，文本向量化");

        System.out.println(embeddingResponse);
    }

}
