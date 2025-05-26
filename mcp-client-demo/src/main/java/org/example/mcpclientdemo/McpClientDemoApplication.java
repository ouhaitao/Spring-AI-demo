package org.example.mcpclientdemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpClientDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(McpClientDemoApplication.class, args);
    }
    
    @Bean
    public ChatClient chatClient(ChatClient.Builder chartClientBuilder, ToolCallbackProvider toolCallbackProvider) {
        return chartClientBuilder
            .defaultTools(toolCallbackProvider)
            .build();
    }
}
