package io.sanzharss.relationship.repository.many_to_many.bidirectionalRepository;

import io.sanzharss.relationship.domain.many_to_many.bidirectional.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
