package com.example.langchain4j08json.service;

import com.example.langchain4j08json.service.NumberExtractor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumberExtractorTest {

    @Autowired
    private NumberExtractor numberExtractor;
    @Test
    void extractInt() {
        int days = numberExtractor.extractInt("我今天要请五天假");

        System.out.println(days);
    }
}