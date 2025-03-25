package com.example.langchain4j06memroy.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

public interface ChatAssistant {

    String chat(String message);


    String chat(@MemoryId Long memoryId, @UserMessage String message);


}
