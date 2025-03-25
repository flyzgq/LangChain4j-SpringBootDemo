package com.example.langchain4j11embeddingtextanalyse;

import com.example.langchain4j11embeddingtextanalyse.PersonalityTrait;
import dev.langchain4j.classification.EmbeddingModelTextClassifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Langchain4J11EmbeddingTextAnalyseApplicationTests {
    @Autowired
    private EmbeddingModelTextClassifier<PersonalityTrait> embeddingModelTextClassifier;

    @Test
    void contextLoads() {
        List<PersonalityTrait> classify = embeddingModelTextClassifier.classify("赠人玫瑰,留有余香");

        System.out.println(classify);
    }

}
