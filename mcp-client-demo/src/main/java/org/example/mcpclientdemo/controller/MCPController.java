package org.example.mcpclientdemo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author parry 2025/05/22
 */
@RestController
@RequestMapping("/mcp/chat")
public class MCPController {
    
    @Autowired
    private ChatClient chatClient;
    
    @GetMapping(value = "/getWeather", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getWeather(String city) {
        System.out.println("getWeather city:" + city);
        return chatClient.prompt().user(city).stream().content();
    }
}
