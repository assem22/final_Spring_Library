package kz.iitu.libraryManagementSystem.service;

import kz.iitu.libraryManagementSystem.entity.User;
//import kz.iitu.libraryManagementSystem.entity.Subscriber;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<User> findAllAuthors();

    Optional<User> findAuthorById(Long id);

    void createAuthor(User user);

    void updateAuthor(User user);

    void deleteAuthor(Long id);

//    List<Subscriber> findAllFollowers();
}
