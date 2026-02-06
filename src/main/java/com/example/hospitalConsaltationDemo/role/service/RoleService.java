package com.example.hospitalConsaltationDemo.role.service;

import com.example.hospitalConsaltationDemo.response.Response;
import com.example.hospitalConsaltationDemo.role.entity.Role;

import java.util.List;


public interface RoleService {

    Response<Role> createRole(Role roleRequest);


    Response<Role> updateRole(Role roleRequest);

    Response<List<Role>> getAllRoleRole();

    Response<?> deleteRole(Long id);

}
