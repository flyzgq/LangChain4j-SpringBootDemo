package com.example.langchain4j04streaming.adptor.controller;


import com.example.langchain4j04streaming.service.ChatAssistant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class ChatController {

    private final ChatAssistant chatAssistant;

    @GetMapping("/chat")
    public Flux<String> chat(@RequestParam("message") String message){
        return chatAssistant.chat(message);
    }
}
