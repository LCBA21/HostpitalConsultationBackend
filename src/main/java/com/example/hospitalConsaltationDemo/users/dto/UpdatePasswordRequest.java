package com.example.hospitalConsaltationDemo.users.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdatePasswordRequest {

    @NotBlank(message = "Old Password Required")
    private String oldPassword;

    @NotBlank(message = "New Password Required")
    private String newPassword;



}
