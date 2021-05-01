package kz.iitu.libraryManagementSystem.service;


import kz.iitu.libraryManagementSystem.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();

    Book findBookById(Long id);

    public List<Book> searchBooks(String keyword);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);
}
