package com.example.langchain4j07prompt.service;

import dev.langchain4j.model.input.structured.StructuredPrompt;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@StructuredPrompt("根据中国{{legal}}法律，解答以下问题：{{question}}")
public class LegalPrompt {
    private String legal;
    private String question;
}
