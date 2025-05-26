package org.example.mcpclientdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatClientTest {
    
    @Autowired
    private ChatClient chatClient;
    
    private static ObjectMapper objectMapper = new ObjectMapper();
    
    @BeforeAll
    public static void init() {
        objectMapper.registerModule(new JavaTimeModule());
    }
    
    @Test
    public void chatResponseTest() throws JsonProcessingException {
        ChatResponse chatResponse = chatClient.prompt().user("你好").call().chatResponse();
        System.out.println(objectMapper.writeValueAsString(chatResponse));
    }
    
}
