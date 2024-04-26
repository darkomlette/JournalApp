package com.example.journalapp.repository;


import com.example.journalapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String username);
    Optional<User> findById(int userId);
}
