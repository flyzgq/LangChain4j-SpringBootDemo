package com.example.langchain4j08json.service;

import com.example.langchain4j08json.service.PersonExtractor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonExtractorTest {

    @Autowired
    private PersonExtractor personExtractor;
    @Test
    void extractPerson() {

        PersonExtractor.Person person = personExtractor.extractPerson("帮我创建一个用户，名字叫张三，生日是1990-01-01");

        System.out.println(person.toString());
    }
}