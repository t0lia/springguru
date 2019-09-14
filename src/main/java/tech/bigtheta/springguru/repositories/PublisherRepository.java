package tech.bigtheta.springguru.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.bigtheta.springguru.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
