package com.example.langchain4j04streaming.service;

import reactor.core.publisher.Flux;

public interface ChatAssistant {

    Flux<String> chat(String message);
}
