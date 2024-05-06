package io.sanzharss.relationship.repository.many_to_many.bidirectionalRepository;

import io.sanzharss.relationship.domain.many_to_many.bidirectional.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
