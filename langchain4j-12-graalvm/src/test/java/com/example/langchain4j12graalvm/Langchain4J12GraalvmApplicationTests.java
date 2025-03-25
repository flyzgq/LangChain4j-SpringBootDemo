package com.example.langchain4j12graalvm;

import dev.langchain4j.code.CodeExecutionEngine;
import dev.langchain4j.code.graalvm.GraalVmJavaScriptExecutionEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Langchain4J12GraalvmApplicationTests {


    @Test
    void contextLoads() {
        CodeExecutionEngine engine = new GraalVmJavaScriptExecutionEngine();

        String code = """
        function fibonacci(n) {
            if (n <= 1) return n;
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
                        
        fibonacci(10)
        """;

        String result = engine.execute(code);
        System.out.println(result);
    }

}
