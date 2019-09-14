package tech.bigtheta.springguru.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.bigtheta.springguru.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> { }
