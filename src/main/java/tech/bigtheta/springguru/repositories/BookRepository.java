package tech.bigtheta.springguru.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.bigtheta.springguru.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
