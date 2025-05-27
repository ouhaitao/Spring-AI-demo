package org.example.mcpclientdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {McpClientDemoApplication.class, ToolConfig.class})
public class ChatClientTest {
    
    /**
     * 自动注入chatClientBuilder
     * 配置文件配了百炼的配置，DashScopeAutoConfiguration会自动创建DashScopeChatModel
     * ChatClientAutoConfiguration会自动拿到CharModel创建chatClientBuilder
     */
    @Autowired
    private ChatClient.Builder chatClientBuilder;
    
    /**
     * 自定义chatClient
     */
    private ChatClient chatClient;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @PostConstruct
    public void init() {
        objectMapper.registerModule(new JavaTimeModule());
        
        // 给了全局的prompt
        chatClient = chatClientBuilder
            .defaultSystem("你是一个电脑客服，你只需要回答用户向你提的电脑相关的问题。其他问题一律不回答")
            // tool的bean名，chatClient提供了多种注册方法，详见源码
            // MCP服务也是一种tool
            .defaultTools("getJobNumber", "recordUserWord")
            .build();
    }
    
    @Test
    public void chatResponseTest() throws JsonProcessingException {
        ChatResponse chatResponse = chatClient.prompt().user("今天天气怎么样").call().chatResponse();
        System.out.println(objectMapper.writeValueAsString(chatResponse));
    }
    
    /**
     * tool测试
     */
    @Test
    public void toolTest() {
        System.out.println(chatClient.prompt().user("你的工号是多少").call().content());
    }
    
}
