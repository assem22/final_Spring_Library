package kz.iitu.libraryManagementSystem.controller;

import io.swagger.annotations.Api;
import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.entity.Role;
import kz.iitu.libraryManagementSystem.entity.User;
import kz.iitu.libraryManagementSystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Api(value = "Role Controller class", description = "This class allows to interact with Role object")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public List<Role> getAuthors() {
        return roleService.getRoles();
    }

    @PostMapping("/create")
    public void createBook(@RequestBody Role role) {
        roleService.createRole(role);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

    @PutMapping("/update/{id}")
    public void updateRole(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id);
        roleService.updateRole(role);
    }
}
