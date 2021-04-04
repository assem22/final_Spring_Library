package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    public void createBook(Book book) {
        bookService.createBook(book);
    }

    public void deleteBook(long bookId) {
        bookService.deleteBook(bookId);
    }

    public void updateBook(Book book) {
        bookService.updateBook(book);
    }

    public List<Book> search(String text){
        return bookService.searchBooks(text);
    }
}
