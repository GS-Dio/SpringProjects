package io.sanzharss.relationship.repository.one_to_one.bidirectionalRepository;

import io.sanzharss.relationship.domain.one_to_one.bidirectional.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {


}
