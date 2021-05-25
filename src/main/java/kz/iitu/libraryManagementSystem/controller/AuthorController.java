package kz.iitu.libraryManagementSystem.controller;

import io.swagger.annotations.Api;
import kz.iitu.libraryManagementSystem.entity.User;
//import kz.iitu.libraryManagementSystem.entity.Subscriber;
import kz.iitu.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/")
@Api(value = "User Controller class", description = "This class allows to interact with User object")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/login")
    public String showLoginForm(User user) {
        return "login";
    }

    @GetMapping("/registration")
    public String showCreateForm(User user) {
        return "registration";
    }
    @RequestMapping("/add-user")
    public String addUser(@AuthenticationPrincipal User currentUser, User user, Model model) {
        if(user.getPassword().length()<2){
            model.addAttribute("users", authorService.findAllAuthors());
            model.addAttribute("message", "password");
            return "registration";

        }
        if (!authorService.createAuthor(user)) {
            model.addAttribute("users", authorService.findAllAuthors());
            model.addAttribute("message", "account");
            return "registration";
        }

        if(currentUser == null){
            return "role";
        }
        return "redirect:/index";
    }

    @RequestMapping("/users")
    public String findAllAuthors(Model model) {
        final List<User> users = authorService.findAllAuthors();

        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/update-user/{id}")
    public String goToUpdate(@PathVariable("id") Long id, Model model) {
        final User user = authorService.findAuthorById(id);

        model.addAttribute("user", user);
        return "user_update";
    }

    @RequestMapping("/user-update/{id}")
    public String updateAuthor(@PathVariable("id") Long id, User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setUser_id(id);
            return "user_update";
        }

        authorService.updateAuthor(user);
        model.addAttribute("user", authorService.findAllAuthors());
        return "redirect:/users";
    }

    @RequestMapping("/user-delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id, Model model) {
        authorService.deleteAuthor(id);

        model.addAttribute("user", authorService.findAllAuthors());
        return "redirect:/users";
    }

//
//    @GetMapping("")
//    public List<User> getAuthors() {
//        return authorService.findAllAuthors();
//    }

    // add user
//    @GetMapping("/create")
//    public void createUserByUsernamePassword(String name, String username,
//                                             String password) {
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
//        user.setUsername(username);
//
//        authorService.createAuthor(user);
//    }
//
//    @PostMapping("/register")
//    public void createAuthor(@RequestBody User user) {
//        authorService.createAuthor(user);
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable("id") Long id) {
//        return authorService.findAuthorById(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable Long id, @RequestBody User user) {
//        user.setUser_id(id);
//        authorService.updateAuthor(user);
//    }
}
