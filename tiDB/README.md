# Agentic TiDB CRUD Example

This is a Spring Boot project that demonstrates CRUD operations using TiDB (a MySQL-compatible distributed database). The project integrates with OpenAI's GPT-4 model for AI-based functionalities and leverages the MCP `@Tool` framework to enable agentic capabilities.

## Features
- Agentic capabilities with MCP `@Tool`
- CRUD operations with TiDB
- Integration with OpenAI GPT-4
- Spring Boot-based architecture
- Logging and debugging enabled for development

## Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- TiDB Cloud account
- OpenAI API key

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Configure the Application**
   Update the `src/main/resources/application.properties` file with your TiDB and OpenAI credentials.

3. **Build the Project**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the Application**
   The application will be available at `http://localhost:8080`.

## Database Schema
The schema is initialized using the `schema-ai-memory.sql` file. Ensure the `spring.sql.init.mode` property is set to `always` in `application.properties`.

## Testing
Run the tests using:
```bash
mvn test
```

## Logging
Logging is configured in `application.properties` for debugging purposes. Adjust the logging levels as needed.

## Agentic Capabilities
This project uses the MCP `@Tool` framework to enable agentic functionalities. The `@Tool` annotations allow seamless integration with OpenAI's GPT-4 model, enabling advanced AI-driven operations.



