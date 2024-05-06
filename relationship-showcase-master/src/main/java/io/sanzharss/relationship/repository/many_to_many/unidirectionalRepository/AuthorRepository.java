package io.sanzharss.relationship.repository.many_to_many.unidirectionalRepository;

import io.sanzharss.relationship.domain.many_to_many.unidirectional.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
