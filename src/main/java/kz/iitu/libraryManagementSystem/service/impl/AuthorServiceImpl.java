package kz.iitu.libraryManagementSystem.service.impl;

import kz.iitu.libraryManagementSystem.entity.User;
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
    public List<User> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<User> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void createAuthor(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authorRepository.saveAndFlush(user);
    }

    @Override
    public void updateAuthor(User user) {
        authorRepository.save(user);
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
        User user = authorRepository.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("User: " + email + " not found!");
        }
        return user;
    }
}
