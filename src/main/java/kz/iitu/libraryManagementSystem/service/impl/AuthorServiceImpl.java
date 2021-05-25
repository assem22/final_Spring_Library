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

import java.util.Collections;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService, UserDetailsService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllAuthors() {
//        List<User> authors =
        return authorRepository.findAll();
    }

    @Override
    public User findAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public boolean createAuthor(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        authorRepository.saveAndFlush(user);
//        return false;

        User userDb = authorRepository.findByUsername(user.getUsername());
        if (userDb != null) {
            return false;
        }
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authorRepository.save(user);
        return true;
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
