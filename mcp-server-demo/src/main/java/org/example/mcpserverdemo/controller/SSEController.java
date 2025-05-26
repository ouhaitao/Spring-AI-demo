//package org.example.mcpserverdemo.controller;
//
//import org.springframework.http.MediaType;
//import org.springframework.http.codec.ServerSentEvent;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//
//import java.time.Duration;
//
///**
// * @author parry 2025/05/23
// */
//@RestController
//public class SSEController {
//
//    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<ServerSentEvent<String>> handleSse() {
//        return Flux.interval(Duration.ofSeconds(1))
//            .map(sequence -> ServerSentEvent.<String>builder()
//                .id(String.valueOf(sequence))
//                .event("message")
//                .data("SSE Message #" + sequence + " from MCP Server")
//                .build());
//    }
//}
