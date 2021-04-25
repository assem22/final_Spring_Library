package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    // add book
    @GetMapping("/create")
    public void createUserByUsernamePassword(String book_name,
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
    public Book getUserById(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }
}


//@Controller
//public class BookController {
//
//    @Autowired
//    private BookService bookService;
//
//    public List<Book> getBooks() {
//        return bookService.findAllBooks();
//    }
//
//    public void createBook(Book book) {
//        bookService.createBook(book);
//    }
//
//    public void deleteBook(long bookId) {
//        bookService.deleteBook(bookId);
//    }
//
//    public void updateBook(Book book) {
//        bookService.updateBook(book);
//    }
//
//    public List<Book> search(String text){
//        return bookService.searchBooks(text);
//    }
//}
