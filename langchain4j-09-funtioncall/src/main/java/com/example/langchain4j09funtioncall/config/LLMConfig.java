package com.example.langchain4j09funtioncall.config;

import com.example.langchain4j09funtioncall.service.FunctionAssistant;
import com.example.langchain4j09funtioncall.service.InvoiceHandler;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMConfig {

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_KEY"))
                .modelName("qwen-turbo")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

//    @Bean
//    public FunctionAssistant functionAssistant(ChatLanguageModel chatLanguageModel) {
//        // 工具说明 ToolSpecification
//        ToolSpecification toolSpecification = ToolSpecification.builder()
//                .name("invoice_assistant")
//                .description("根据用户提交的开票信息，开具发票")
//                .parameters(JsonObjectSchema.builder()
//                        .addStringProperty("companyName", "公司名称")
//                        .build())
//                .parameters(JsonObjectSchema.builder()
//                        .addStringProperty("dutyNumber", "税号")
//                        .build())
//                .parameters(JsonObjectSchema.builder()
//                        .addStringProperty("amount", "金额")
//                        .build())
//                .build();
//
//        // 业务逻辑 ToolExecutor
//        ToolExecutor toolExecutor = (toolExecutionRequest, memoryId) -> {
//            String arguments1 = toolExecutionRequest.arguments();
//            System.out.println("arguments1 =>>>> " + arguments1);
//            return "开具成功";
//        };
//
//        return AiServices.builder(FunctionAssistant.class)
//                .chatLanguageModel(chatLanguageModel)
//                .tools(Map.of(toolSpecification, toolExecutor))
//                .build();
//    }

    @Bean
    public FunctionAssistant functionAssistant(ChatLanguageModel chatLanguageModel) {
        return AiServices.builder(FunctionAssistant.class)
                .chatLanguageModel(chatLanguageModel)
                .tools(new InvoiceHandler())
                .build();
    }
}
