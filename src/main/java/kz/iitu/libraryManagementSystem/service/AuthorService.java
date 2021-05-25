package kz.iitu.libraryManagementSystem.service;

import kz.iitu.libraryManagementSystem.entity.User;
//import kz.iitu.libraryManagementSystem.entity.Subscriber;

import java.util.List;

public interface AuthorService {
    List<User> findAllAuthors();

    User findAuthorById(Long id);

    boolean createAuthor(User user);

    void updateAuthor(User user);

    void deleteAuthor(Long id);

//    List<Subscriber> findAllFollowers();
}
