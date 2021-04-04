package kz.iitu.libraryManagementSystem.repository;

import kz.iitu.libraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.book_name LIKE %?1%" + " OR b.author.author_name LIKE %?1%" + " OR b.book_genre LIKE %?1%" + " OR b.description LIKE %?1%")
    public List<Book> search(String keyword);
}
