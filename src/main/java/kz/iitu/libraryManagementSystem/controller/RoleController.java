package kz.iitu.libraryManagementSystem.controller;

import io.swagger.annotations.Api;
import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.entity.Role;
import kz.iitu.libraryManagementSystem.entity.User;
import kz.iitu.libraryManagementSystem.service.AuthorService;
import kz.iitu.libraryManagementSystem.service.BookService;
import kz.iitu.libraryManagementSystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/roles")
@Api(value = "Role Controller class", description = "This class allows to interact with Role object")
public class RoleController {

    private final RoleService roleService;
    private final AuthorService authorService;

    @Autowired
    public RoleController(RoleService roleService, AuthorService authorService) {
        this.roleService = roleService;
        this.authorService = authorService;
    }

    @GetMapping("/role")
    public String showRoleForm(Role role, Model model) {
        model.addAttribute("authors", authorService.findAllAuthors());
        return "role";
    }
    @RequestMapping("/add-user-role")
    public String addRoleToUser(Role role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        roleService.createRole(role);
        model.addAttribute("roles", roleService.getRoles());
        return "redirect:/login";
    }

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
