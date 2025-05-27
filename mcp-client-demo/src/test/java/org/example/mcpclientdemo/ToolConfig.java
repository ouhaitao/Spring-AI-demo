package org.example.mcpclientdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;

import java.util.function.Supplier;

/**
 * @author parry 2025/05/27
 */
public class ToolConfig {
    
    /**
     * Function也可以作为tool
     */
    @Bean("getJobNumber")
    @Description("获取工号")
    public Supplier<String> getJobNumber() {
        return () -> {
            System.out.println("getJobNumber被调用");
            return "AI.001";
        };
    }
    
}
