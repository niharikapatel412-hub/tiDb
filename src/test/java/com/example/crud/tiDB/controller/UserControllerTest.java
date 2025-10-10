package com.example.crud.tiDB.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Mock
    private UserController userController;

    @Mock
    private TestRestTemplate restTemplate;

    @BeforeEach
    private void setUp() {

    }


    @Test
    public void testGetUsers() {
        // Implement test logic here
    }


}
