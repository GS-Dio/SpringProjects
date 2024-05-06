package io.sanzharss.relationship.repository.one_to_one.unidirectionalRepository;

import io.sanzharss.relationship.domain.one_to_one.unidirectional.Capital;
import org.springframework.data.repository.CrudRepository;

public interface CapitalRepository extends CrudRepository<Capital, Long> {
}
