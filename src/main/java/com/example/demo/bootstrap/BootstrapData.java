package com.example.demo.bootstrap;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author - Ceren Ercan at 30.09.2021
 */
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publisher");
        publisher.setAddress("Publisher Address");
        publisher.setCity("St. Petersburg");
        publisher.setState("FL");
        publisher.setZip("12345");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        saveTo(publisher, eric, ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "236720");

        saveTo(publisher, rod, noEJB);


        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of books: " + publisher.getBooks().size());

    }

    private void saveTo(Publisher publisher, Author author, Book book) {
        author.getBooks().add(book);
        book.getAuthors().add(author);

        book.setPublishers(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);
    }
}
