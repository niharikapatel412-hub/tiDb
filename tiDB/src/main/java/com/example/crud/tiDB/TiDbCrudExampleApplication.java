package com.example.crud.tiDB;

import com.example.crud.tiDB.service.DummyTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages="com.example.crud.tiDB")
public class TiDbCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiDbCrudExampleApplication.class, args);
	}


}
