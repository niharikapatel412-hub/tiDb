package com.example.crud.tiDB.controller;

import com.example.crud.tiDB.models.User;
import com.example.crud.tiDB.repository.UserRepository;
import com.example.crud.tiDB.service.UserAIService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    private final UserAIService uiService;

    public UserController(UserRepository repository, UserAIService uiService) {
        this.repository = repository;
        this.uiService = uiService;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User existing = repository.findById(id).orElseThrow();
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/ai/summary")
    public String summarizeUsers() {
        List<User> users = repository.findAll();

        StringBuilder sb = new StringBuilder("Here are the users:\n");
        for (User u : users) {
            sb.append("- ").append(u.getName()).append(" (").append(u.getEmail()).append(")\n");
        }

        String prompt = """
                Summarize this user list in one paragraph for a management report:
                %s
                """.formatted(sb);

        return uiService.ask(prompt);
    }
}
