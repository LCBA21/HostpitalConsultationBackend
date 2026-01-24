package com.example.hospitalConsaltationDemo.users.repository;

import com.example.hospitalConsaltationDemo.users.enity.PasswordResetCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordRestRepository  extends JpaRepository<PasswordResetCode,Long> {

    Optional<PasswordResetCode> findByCode(String code);
    void deleteByUserId(Long userId);
}
