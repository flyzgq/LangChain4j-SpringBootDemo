package com.example.langchain4j17ragsearch.service;

import com.example.langchain4j17ragsearch.service.ChatAssistant;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentByCharacterSplitter;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
class ChatAssistantTest {
    @Autowired
    InMemoryEmbeddingStore<TextSegment> embeddingStore;

    @Autowired
    ChatAssistant chatAssistant;

    @Test
    void testAdd() {
        Document document = FileSystemDocumentLoader.loadDocument("C:\\Users\\fly\\Downloads\\一个简单的订单系统.docx");
        EmbeddingStoreIngestor.ingest(document, embeddingStore);


        String chat = chatAssistant.chat("需求是什么");
        System.out.println(chat);
    }

    @Test
    void test1() throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\fly\\Downloads\\一个简单的订单系统.docx");
        Document document = new ApacheTikaDocumentParser().parse(fileInputStream);

        System.out.println(document);
    }

    @Test
    void test2() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\fly\\Downloads\\一个简单的订单系统.docx");
        Document document = new ApacheTikaDocumentParser().parse(fileInputStream);

        List<TextSegment> split = new DocumentByCharacterSplitter(100, 0).split(document);

        System.out.println(split);

    }
}