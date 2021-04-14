package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Author;
import kz.iitu.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAuthors() {
        return authorService.findAllAuthors();
    }

    @PostMapping("")
    public void createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
    }

    @GetMapping("/{id}")
    public Optional<Author> getUserById(@PathVariable("id") Long id) {
        return authorService.findAuthorById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Author author) {
        author.setAuthor_id(id);
        authorService.updateAuthor(author);
    }
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
