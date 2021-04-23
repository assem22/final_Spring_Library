package kz.iitu.libraryManagementSystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "author")
public class Author implements  UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @OneToMany(mappedBy="author", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Book> books;

//    @ManyToMany(mappedBy = "publishers",fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    private List<Subscriber> subscribers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_relation",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="parent_id")})
    @JsonIgnore
    private List<Author> following = new ArrayList<>();

    @ManyToMany(mappedBy = "following")
    private List<Author> followers = new ArrayList<>();

    public Author(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Author() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Author> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Author> followers) {
        this.followers = followers;
    }

    public List<Author> getFollowing() {
        return following;
    }

    public void setFollowing(List<Author> following) {
        this.following = following;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long author_id) {
        this.id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String author_name) {
        this.name = author_name;
    }

    public void setUsername(String author_email) {
        this.username = author_email;
    }

    public void setPassword(String author_password) {
        this.password = author_password;
    }

//    public List<Subscriber> getSubscribers() {
//        return subscribers;
//    }
//
//    public void setSubscribers(List<Subscriber> subscribers) {
//        this.subscribers = subscribers;
//    }


    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + id +
                ", author_name='" + name + '\'' +
                ", author_email='" + username + '\'' +
                ", author_password='" + password + '\'' +
                ", roles=" + roles +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
