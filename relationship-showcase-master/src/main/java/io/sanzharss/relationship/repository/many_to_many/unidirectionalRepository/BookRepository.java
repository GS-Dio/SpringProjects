package io.sanzharss.relationship.repository.many_to_many.unidirectionalRepository;

import io.sanzharss.relationship.domain.many_to_many.unidirectional.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
