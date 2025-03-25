package com.example.langchain4j03simple.listener;

import dev.langchain4j.model.chat.listener.ChatModelErrorContext;
import dev.langchain4j.model.chat.listener.ChatModelListener;
import dev.langchain4j.model.chat.listener.ChatModelRequestContext;
import dev.langchain4j.model.chat.listener.ChatModelResponseContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyChatModelListener implements ChatModelListener {

    @Override
    public void onRequest(ChatModelRequestContext requestContext) {
        log.info("请求{}",requestContext.toString());
    }

    @Override
    public void onResponse(ChatModelResponseContext responseContext) {
        log.info("响应:{}",responseContext.toString());
    }

    @Override
    public void onError(ChatModelErrorContext errorContext) {
        log.info(errorContext.toString());
    }
}
