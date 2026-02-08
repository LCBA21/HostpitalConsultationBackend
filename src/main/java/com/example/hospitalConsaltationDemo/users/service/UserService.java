package com.example.hospitalConsaltationDemo.users.service;

import com.example.hospitalConsaltationDemo.response.Response;
import com.example.hospitalConsaltationDemo.users.dto.UpdatePasswordRequest;
import com.example.hospitalConsaltationDemo.users.dto.UserDTO;
import com.example.hospitalConsaltationDemo.users.enity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {


    User getCurrentUser();

    Response<UserDTO> getMyUserDetails();

    Response<UserDTO> getUserById(Long userId);

    Response<List<UserDTO>> getAllUsers();

    Response<?> updatePassword(UpdatePasswordRequest updatePasswordRequest);

    Response<?> uploadProfilePicture(MultipartFile file);

    Response<?> uploadProfilePictureToS3(MultipartFile file);


}
