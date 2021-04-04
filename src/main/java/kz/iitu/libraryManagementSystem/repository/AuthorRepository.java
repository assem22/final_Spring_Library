package kz.iitu.libraryManagementSystem.repository;

import kz.iitu.libraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
