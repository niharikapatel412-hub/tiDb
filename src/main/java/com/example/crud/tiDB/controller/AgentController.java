package com.example.crud.tiDB.controller;

import com.example.crud.tiDB.models.User;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;
    private final JdbcChatMemoryRepository chatMemoryRepository;

    public AgentController(ChatClient.Builder builder, ToolCallbackProvider toolCallbackProvider, ChatMemory chatMemory, JdbcChatMemoryRepository chatMemoryRepository) {

        this.chatMemory = chatMemory;
        this.chatMemoryRepository = chatMemoryRepository;
        this.chatClient = builder
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultToolCallbacks(toolCallbackProvider)
                .build();
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String prompt,
                      @RequestParam(defaultValue = "default-session") String sessionId) {


        var chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(chatMemoryRepository)
                .maxMessages(20)
                .build();

        return chatClient
                .prompt()
                .advisors(MessageChatMemoryAdvisor.builder(chatMemory).conversationId(sessionId).build())
                .user(prompt)
                .call()
                .content();
    }

    @GetMapping("/ask_test")
    public User askTest(@RequestParam String prompt) {
        String systemMessage = "Please don't add your pii information.";
        return chatClient
                .prompt()
                .system(systemMessage)
                .user(prompt)
                .call()
                .entity(User.class);
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





