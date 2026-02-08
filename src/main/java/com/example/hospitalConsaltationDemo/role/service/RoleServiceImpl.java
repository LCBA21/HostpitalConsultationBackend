package com.example.hospitalConsaltationDemo.role.service;

import com.example.hospitalConsaltationDemo.exceptions.NotFoundException;
import com.example.hospitalConsaltationDemo.response.Response;
import com.example.hospitalConsaltationDemo.role.entity.Role;
import com.example.hospitalConsaltationDemo.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;


    @Override
    public Response<Role> createRole(Role roleRequest) {
        Role  savedRole =roleRepository.save(roleRequest);
        return Response.<Role>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Role Saved Successfully")
                .data(savedRole)
                .build();
    }

    @Override
    public Response<Role> updateRole(Role roleRequest) {

        Role role=roleRepository.findById(roleRequest.getId())
                .orElseThrow(()-> new NotFoundException("Role Not Found"));

        role.setName(roleRequest.getName());

        Role updatedRole = roleRepository.save(role);
        return Response.<Role>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Role Updated Successfully")
                .data(updatedRole)
                .build();
    }

    @Override
    public Response<List<Role>> getAllRoleRole() {

        List<Role> roles  = roleRepository.findAll();
        return Response.<List<Role>>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Role Received Successfully")
                .data(roles)
                .build();
    }

    @Override
    public Response<?> deleteRole(Long id) {

        if (!roleRepository.existsById(id)){
            throw new NotFoundException("Role Not Found");
        }

        roleRepository.deleteById(id);
         return Response.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Role Deleted Successfully")
                .build();
    }
}
