package com.example.crud.tiDB.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DummyTool {
    @Tool(name = "ping", description = "Simple health check tool")
    public String ping() {
        return "pong";
    }
}
