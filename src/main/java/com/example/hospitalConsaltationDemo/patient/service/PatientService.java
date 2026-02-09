package com.example.hospitalConsaltationDemo.patient.service;

import com.example.hospitalConsaltationDemo.enums.BloodGroup;
import com.example.hospitalConsaltationDemo.enums.Genotype;
import com.example.hospitalConsaltationDemo.patient.dto.PatientDTO;
import com.example.hospitalConsaltationDemo.response.Response;

import java.util.List;

public interface PatientService {

    Response<PatientDTO> getPatientProfile();

    Response<?> updatePatientProfile(PatientDTO patientDTO);

    Response<PatientDTO> getPatientById(Long patientId);

    Response<List<BloodGroup>> getAllBloodGroupEnums();
    Response<List<Genotype>>getAllGenotypeEnums();
}
