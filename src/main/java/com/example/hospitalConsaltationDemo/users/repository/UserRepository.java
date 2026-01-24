package com.example.hospitalConsaltationDemo.users.repository;

import com.example.hospitalConsaltationDemo.users.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
