package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public String findAllBooks(Model model) {
        final List<Book> books = bookService.findAllBooks();

        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    // add book
    @GetMapping("/create")
    public void createBookByUsernamePassword(String book_name,
                                             String book_genre,
                                             String description) {
        Book book = new Book();
        book.setBook_name(book_name);
        book.setBook_genre(book_genre);
        book.setDescription(description);

        bookService.createBook(book);
    }

    @PostMapping("/newbook")
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/update/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setBook_id(id);
        bookService.updateBook(book);
    }

    @GetMapping("/find/")
    public List<Book> search(@RequestParam String text){
        return bookService.searchBooks(text);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }
}
