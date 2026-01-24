package com.example.hospitalConsaltationDemo.users.dto;


import com.example.hospitalConsaltationDemo.enums.Specialization;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequest {

    @NotBlank(message = "Name Required")
    private String name;

    private Specialization specialization;

    private String licenceNumber;

    @NotBlank
    @Email
    private String email;

    private List<String> roles;

    @NotBlank(message = "Password Required")
    private String password;
}
