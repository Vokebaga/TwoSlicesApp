package com.example.kzassettwoslices.repository;

import com.example.kzassettwoslices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
