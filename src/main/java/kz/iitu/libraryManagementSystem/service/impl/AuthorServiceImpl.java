package kz.iitu.libraryManagementSystem.service.impl;

import kz.iitu.libraryManagementSystem.entity.Author;
//import kz.iitu.libraryManagementSystem.entity.Subscriber;
import kz.iitu.libraryManagementSystem.repository.AuthorRepository;
import kz.iitu.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService, UserDetailsService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void createAuthor(Author author) {
        author.setPassword(passwordEncoder.encode(author.getPassword()));
        authorRepository.saveAndFlush(author);
    }

    @Override
    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

//    @Override
//    public List<Subscriber> findAllFollowers() {
//        return authorRepository.;
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Author author = authorRepository.findByUsername(email);
        if (author == null) {
            throw new UsernameNotFoundException("User: " + email + " not found!");
        }
        return author;
    }
}
