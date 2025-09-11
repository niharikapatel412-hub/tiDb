package com.example.crud.tiDB.repository;

import com.example.crud.tiDB.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
