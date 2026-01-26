package com.example.hospitalConsaltationDemo.doctor.repository;

import com.example.hospitalConsaltationDemo.doctor.entity.Doctor;
import com.example.hospitalConsaltationDemo.enums.Specialization;
import com.example.hospitalConsaltationDemo.users.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Optional<Doctor> findByUser(User user);

    List<Doctor> findBySpecialization(Specialization specialization);
}
