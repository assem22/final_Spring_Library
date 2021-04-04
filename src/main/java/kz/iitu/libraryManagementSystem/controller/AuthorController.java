package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Author;
import kz.iitu.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public List<Author> getAuthors() {
        return authorService.findAllAuthors();
    }

    public void createAuthor(Author author) {
        authorService.createAuthor(author);
    }

    public void update(Author author) {
        authorService.updateAuthor(author);
    }
}
