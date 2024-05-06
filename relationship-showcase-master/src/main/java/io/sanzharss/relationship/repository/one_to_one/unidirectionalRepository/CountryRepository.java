package io.sanzharss.relationship.repository.one_to_one.unidirectionalRepository;

import io.sanzharss.relationship.domain.one_to_one.unidirectional.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
