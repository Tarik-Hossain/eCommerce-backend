package com.example.ecommerce.features.user.repository;

import com.example.ecommerce.features.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
