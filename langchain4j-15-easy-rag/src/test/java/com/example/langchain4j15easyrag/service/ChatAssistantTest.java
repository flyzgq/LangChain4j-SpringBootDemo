package com.example.langchain4j15easyrag.service;

import com.example.langchain4j15easyrag.service.ChatAssistant;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatAssistantTest {

    @Autowired
    private InMemoryEmbeddingStore embeddingStore;

    @Autowired
    private ChatAssistant assistant;
    @Test
    void chat() {
        Document document = FileSystemDocumentLoader.loadDocument("C:\\Users\\fly\\Downloads\\一个简单的订单系统.docx");
        EmbeddingStoreIngestor.ingest(document, embeddingStore);

        String chat = assistant.chat("需求是什么");
        System.out.println(chat);
    }
}