package com.example.crud.tiDB.config;

import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepositoryDialect;

public class MySQLChatMemoryRepositoryDialect implements JdbcChatMemoryRepositoryDialect {


    @Override
    public String getSelectMessagesSql() {
        return null;
    }

    @Override
    public String getInsertMessageSql() {
        return "INSERT INTO SPRING_AI_CHAT_MEMORY (conversation_id, content, type, metadata, timestamp) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
    }

    @Override
    public String getSelectConversationIdsSql() {
        return "SELECT content, type FROM SPRING_AI_CHAT_MEMORY WHERE conversation_id = ? ORDER BY timestamp";
    }

    @Override
    public String getDeleteMessagesSql() {
        return null;
    }
}
