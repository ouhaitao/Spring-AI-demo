package org.example.mcpserverdemo;

import org.example.mcpserverdemo.tool.MCPTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpServerDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(McpServerDemoApplication.class, args);
    }
    
    
    @Bean
    public ToolCallbackProvider toolCallbackProvider(MCPTool mcpTool) {
        return MethodToolCallbackProvider.builder()
            .toolObjects(mcpTool)
            .build();
    }
    
}
