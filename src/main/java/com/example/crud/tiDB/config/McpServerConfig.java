package com.example.crud.tiDB.config;

import com.example.crud.tiDB.service.UserToolService;
import com.example.crud.tiDB.service.DummyTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpServerConfig {

    @Bean
    public ToolCallbackProvider configureTools(DummyTool dummyTool, UserToolService userToolService) {
        return  MethodToolCallbackProvider.builder().
                toolObjects(dummyTool,userToolService)
        .build();
    }
}
