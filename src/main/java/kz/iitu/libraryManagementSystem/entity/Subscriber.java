package kz.iitu.libraryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriber_id;
    private String subscriber_name;
    private String subscriber_email;
    private String subscriber_password;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Author> publishers = new ArrayList<>();

    public Subscriber(String subscriber_name, String subscriber_email, String subscriber_password) {
        this.subscriber_name = subscriber_name;
        this.subscriber_email = subscriber_email;
        this.subscriber_password = subscriber_password;
    }

    public Subscriber() {

    }

    public Long getSubscriber_id() {
        return subscriber_id;
    }

    public void setSubscriber_id(Long subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public String getSubscriber_name() {
        return subscriber_name;
    }

    public void setSubscriber_name(String subscriber_name) {
        this.subscriber_name = subscriber_name;
    }

    public String getSubscriber_email() {
        return subscriber_email;
    }

    public void setSubscriber_email(String subscriber_email) {
        this.subscriber_email = subscriber_email;
    }

    public String getSubscriber_password() {
        return subscriber_password;
    }

    public void setSubscriber_password(String subscriber_password) {
        this.subscriber_password = subscriber_password;
    }

    public List<Author> getPublishers() {
        return publishers;
    }

    public void setPublishers(Author publisher) {
        this.publishers.add(publisher);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "subscriber_id=" + subscriber_id +
                ", subscriber_name='" + subscriber_name + '\'' +
                ", subscriber_email='" + subscriber_email + '\'' +
                ", subscriber_password='" + subscriber_password + '\'' +
                ", publishers=" + publishers +
                '}';
    }
}
