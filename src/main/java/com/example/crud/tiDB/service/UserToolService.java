package com.example.crud.tiDB.service;

import com.example.crud.tiDB.models.User;
import com.example.crud.tiDB.repository.UserRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class UserToolService {

    private final UserRepository userRepository;

    public UserToolService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Tool(name = "list_users", description = "List all users from TiDB database")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Tool(name = "get_user_by_id", description = "Fetch a user by their ID")
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Tool(name = "create_user", description = "Create a new user with name and email")
    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        System.out.println("Creating user: " + name + ", " + email);
        return userRepository.save(user);
    }

    @Tool(name = "delete_user", description = "Delete user by ID")
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted: " + id;
    }

}
