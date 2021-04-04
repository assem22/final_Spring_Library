package kz.iitu.libraryManagementSystem.service.impl;

import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.repository.BookRepository;
import kz.iitu.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        if (keyword != null) {
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Book updatedSubscriber = bookRepository.findById(book.getBook_id()).get();
        bookRepository.save(updatedSubscriber);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
