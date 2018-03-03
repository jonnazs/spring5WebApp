package com.jonnazs.spring5WebApp.bootstrap;

import com.jonnazs.spring5WebApp.model.Author;
import com.jonnazs.spring5WebApp.model.Book;
import com.jonnazs.spring5WebApp.model.Publisher;
import com.jonnazs.spring5WebApp.repositories.AuthorRepository;
import com.jonnazs.spring5WebApp.repositories.BookRepository;
import com.jonnazs.spring5WebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher hc = new Publisher("Harper Collins", "NY");
        Publisher wrox = new Publisher("Wrox", "Cincinaty WY");
        publisherRepository.save(hc);
        publisherRepository.save(wrox);
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB= new Book("J2EE Development withour EJB", "23444", wrox);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }
}
