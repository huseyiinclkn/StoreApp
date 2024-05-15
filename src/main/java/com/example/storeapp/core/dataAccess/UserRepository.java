package com.example.storeapp.core.dataAccess;

import com.example.storeapp.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}
