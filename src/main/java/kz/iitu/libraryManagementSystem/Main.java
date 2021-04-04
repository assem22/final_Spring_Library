package kz.iitu.libraryManagementSystem;


import kz.iitu.libraryManagementSystem.config.SpringConfig;
import kz.iitu.libraryManagementSystem.controller.AuthorController;
import kz.iitu.libraryManagementSystem.controller.BookController;
import kz.iitu.libraryManagementSystem.controller.SubscriberController;
import kz.iitu.libraryManagementSystem.entity.Author;
import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.entity.Subscriber;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
        private static Scanner in;
        private static AuthorController authorController;
        private static BookController bookController;
        private static SubscriberController subscriberController;

    public static void main (String[]args){

            in = new Scanner(System.in);
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
            authorController = context.getBean("authorController", AuthorController.class);
            bookController = context.getBean("bookController", BookController.class);
            subscriberController = context.getBean("subscriberController", SubscriberController.class);

            while (true) {
                menu();
            }
        }

        private static void menu () {
            System.out.println("[1] Sign in as author\n" +
                    "[2] Sign in as reader\n" +
                    "[3] Sign up as author\n" +
                    "[4] Sign up as reader\n" +
                    "[5] exit");
            int selector = in.nextInt();
            switch (selector) {
                case 1:
                    loginAuthor();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    createAuthor();
                    break;
                case 4:
                    createUser();
                    break;
                case 5:
                    System.exit(0);
            }
        }

        private static void loginAuthor () {
            System.out.println("Log in to site:\nEnter the login");
            String login = in.next();
            System.out.println("Enter the password");
            String password = in.next();
            for (Author author : authorController.getAuthors()) {
                if (author.getAuthor_email().equals(login) && author.getAuthor_password().equals(password)) {
                    System.out.println("Welcome, " + author.getAuthor_name());
                    Boolean check = true;
                    while (check) {
                        check = menuForAuthor(author);
                    }
                }
            }
        }

        private static Boolean menuForAuthor (Author author){
            System.out.println("[1] Create a book\n" +
                    "[2] Delete a book\n" +
                    "[3] My books\n" +
                    "[4] Go to main");
            switch (in.nextInt()) {
                case 1:
                    System.out.println("Enter the title");
                    String title = in.next();
                    System.out.println("Enter the genre");
                    String genre = in.next();
                    System.out.println("Enter the description of book");
                    String description = in.next();
                    bookController.createBook(new Book(title, genre, description, author));
                    break;
                case 2:
                    for (Book book : bookController.getBooks()) {
                        if (book.getAuthor().getAuthor_id().equals(author.getAuthor_id())) {
                            System.out.println(book);
                        }
                    }
                    System.out.println("Enter the post id that you want to delete");
                    int postID = in.nextInt();
                    bookController.deleteBook(postID);
                    break;
                case 3:
                    for (Book book : bookController.getBooks()) {
                        if (book.getAuthor().getAuthor_id().equals(author.getAuthor_id())) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                    return false;
            }
            return true;
        }

        private static void createUser () {
            System.out.println("Enter the name");
            String name = in.next();
            System.out.println("Enter the email");
            String login = in.next();
            if (subscriberController.getSubscribers() != null) {
                for (Subscriber subscriber : subscriberController.getSubscribers()) {
                    if (subscriber.getSubscriber_email().equals(login)) {
                        System.out.println("Such login already exists");
                        return;
                    }
                }
            }
            System.out.println("Enter the password");
            String password = in.next();

            System.out.println("Repeat the password");
            String repassword = in.next();

            if (password.equals(repassword)) {
                subscriberController.createSubscribers(new Subscriber(name, login, password));
                login();
            } else {
                System.out.println("Try again");
                createUser();
            }
        }

        private static void login () {
            System.out.println("Log in to site:\nEnter the login");
            String login = in.next();
            System.out.println("Enter the password");
            String password = in.next();
            for (Subscriber subscriber : subscriberController.getSubscribers()) {
                if (subscriber.getSubscriber_email().equals(login) && subscriber.getSubscriber_password().equals(password)) {
                    System.out.println("Welcome, " + subscriber.getSubscriber_name());
                    Boolean check = true;
                    while (check) {
                        check = menuForSubscriber(subscriber);
                    }
                }
            }
        }

        private static void createAuthor () {
            System.out.println("Enter the name");
            String name = in.next();
            System.out.println("Enter the email");
            String login = in.next();
            if (authorController.getAuthors() != null) {
                for (Author author : authorController.getAuthors()) {
                    if (author.getAuthor_email().equals(login)) {
                        System.out.println("Such login already exists");
                        return;
                    }
                }
            }
            System.out.println("Enter the password");
            String password = in.next();

            System.out.println("Repeat the password");
            String repassword = in.next();

            if (password.equals(repassword)) {
                authorController.createAuthor(new Author(name, login, password));
                loginAuthor();
            } else {
                System.out.println("Try again");
                createAuthor();
            }
        }

        private static Boolean menuForSubscriber (Subscriber subscriber){
            System.out.println("[1] show all authors\n" +
                    "[2] show followed authors\n" +
                    "[3] search\n" +
                    "[3] Go to main");
            switch (in.nextInt()) {
                case 1:
                    for (Author author : authorController.getAuthors()) {
                        System.out.println(author);
                    }
                    System.out.println("[1] follow one\n" +
                            "[2] go back");
                    int choice = in.nextInt();
                    if (choice == 2) {
                        return true;
                    } else if (choice == 1) {
                        System.out.println("Enter the id of author");
                        int authorId = in.nextInt();
                        for (Author author : authorController.getAuthors()) {
                            if (author.getAuthor_id() == authorId) {
                                subscriber.getPublishers().add(author);
                                author.getSubscribers().add(subscriber);
                                subscriberController.update(subscriber);
                            }
                        }
                        return true;
                    }
                    break;
                case 2:
                    for (Author author : subscriber.getPublishers()) {
                        System.out.println(author);
//                    for (Book book: bookController.getBooks()){
//                        if (book.getAuthor().getAuthor_id().equals(author.getAuthor_id())){
//                            System.out.println(book);
//                        }
//                    }
                    }
                    return true;
                case 3:
                    in.nextLine();
                    System.out.println("Search: ");
                    String search = in.nextLine();
                    List<Book> results = bookController.search(search);
                    for (Book book: results){
                        System.out.println(book);
                    }
                    return true;
                case 4:
                    return false;
            }
            return false;
        }

        private static void follow (Subscriber subscriber){
            System.out.println("[1] follow one\n" +
                    "[2] go back");
        }
    }

