package com.example.hospitalConsaltationDemo.consultation.repository;

import com.example.hospitalConsaltationDemo.consultation.entity.Consultation;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

    Optional<Consultation> findByAppointmentId(Long appointmentId);

    List<Consultation>findByAppointmentPatientIdOrderByConsultationDateDesc(Long patientId);
}
