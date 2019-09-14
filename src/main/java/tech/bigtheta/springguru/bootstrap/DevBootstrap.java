package tech.bigtheta.springguru.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tech.bigtheta.springguru.model.Author;
import tech.bigtheta.springguru.model.Book;
import tech.bigtheta.springguru.model.Publisher;
import tech.bigtheta.springguru.repositories.AuthorRepository;
import tech.bigtheta.springguru.repositories.BookRepository;
import tech.bigtheta.springguru.repositories.PublisherRepository;

@Component
public class DevBootstrap {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @EventListener()
    public void init(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher("publisher", "bacon streent");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Jonson");
        Book noEJB = new Book("J2EE development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

}
