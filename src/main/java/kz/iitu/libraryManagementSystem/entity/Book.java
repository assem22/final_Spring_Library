package kz.iitu.libraryManagementSystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    private String book_name;
    private String book_genre;
    private String description;

    @Column(name = "user_id")
    private Long authorId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User author;

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_genre='" + book_genre + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author.getName() + '\'' +
                '}';
    }
}
