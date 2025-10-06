package com.example.crud.tiDB.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final ChatClient chatClient;

    public AgentController(ChatClient.Builder builder, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = builder
                .defaultToolCallbacks(toolCallbackProvider)
                .build();
    }


    @GetMapping("/ask")
    public String ask(@RequestParam String prompt) {
        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }

    @GetMapping("/ask1")
    public String askTest(@RequestParam String prompt) {
        System.out.println("ChatClient called with prompt: " + prompt);

        String response = chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();

        System.out.println("Model response: " + response);
        return response;
    }
}
