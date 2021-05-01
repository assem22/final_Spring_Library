package kz.iitu.libraryManagementSystem.service;

import kz.iitu.libraryManagementSystem.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    void createRole(Role role);
    void updateRole(Role role);
    void deleteRole(Long id);
}
