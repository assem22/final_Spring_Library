package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Author;
//import kz.iitu.libraryManagementSystem.entity.Subscriber;
import kz.iitu.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAuthors() {
        return authorService.findAllAuthors();
    }

    // add user
    @GetMapping("/create")
    public void createUserByUsernamePassword(String name, String username,
                                             String password) {
        Author user = new Author();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);

        authorService.createAuthor(user);
    }

    @PostMapping("/register")
    public void createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
    }

    @GetMapping("/{id}")
    public Optional<Author> getUserById(@PathVariable("id") Long id) {
        return authorService.findAuthorById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        authorService.updateAuthor(author);
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
