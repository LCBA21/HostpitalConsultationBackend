package com.example.hospitalConsaltationDemo.patient.repository;

import com.example.hospitalConsaltationDemo.patient.entity.Patient;
import com.example.hospitalConsaltationDemo.users.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByUser(User user);
}
