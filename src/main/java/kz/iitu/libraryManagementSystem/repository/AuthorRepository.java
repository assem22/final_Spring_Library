package kz.iitu.libraryManagementSystem.repository;

import kz.iitu.libraryManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<User, Long> {
    User findByUsername(String email);
    List<User> findAllByRoles(String role);
}
