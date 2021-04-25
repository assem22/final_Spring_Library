package kz.iitu.libraryManagementSystem.repository;

import kz.iitu.libraryManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<User, Long> {
//    Author findByAuthor_email(String email);
    User findByUsername(String email);
}
