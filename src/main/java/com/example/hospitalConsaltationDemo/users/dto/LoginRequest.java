package com.example.hospitalConsaltationDemo.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "Email Required")
    @Email
    private String email;

    @NotBlank(message = "Password Required")
    private String password;



}
