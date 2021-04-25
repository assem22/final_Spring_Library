package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.User;
//import kz.iitu.libraryManagementSystem.entity.Subscriber;
import kz.iitu.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<User> getAuthors() {
        return authorService.findAllAuthors();
    }

    // add user
    @GetMapping("/create")
    public void createUserByUsernamePassword(String name, String username,
                                             String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);

        authorService.createAuthor(user);
    }

    @PostMapping("/register")
    public void createAuthor(@RequestBody User user) {
        authorService.createAuthor(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return authorService.findAuthorById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        user.setUser_id(id);
        authorService.updateAuthor(user);
    }

//    @GetMapping("/followers")
//    public List<Subscriber> getSubscribers() {
//        return authorService.findAllFollowers();
//    }
}

//@Controller
//public class AuthorController {
//
//    @Autowired
//    private AuthorService authorService;
//    public List<Author> getAuthors() {
//        return authorService.findAllAuthors();
//    }
//
//    public void createAuthor(Author author) {
//        authorService.createAuthor(author);
//    }
//
//    public void update(Author author) {
//        authorService.updateAuthor(author);
//    }
//}
