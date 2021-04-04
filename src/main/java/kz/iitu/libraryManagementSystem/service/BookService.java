package kz.iitu.libraryManagementSystem.service;


import kz.iitu.libraryManagementSystem.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAllBooks();

//    public List<Book> searchBooks(String keyword);

    Optional<Book> findBookById(Long id);

    public List<Book> searchBooks(String keyword);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);
}
