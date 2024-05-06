package io.sanzharss.relationship.repository.one_to_one.bidirectionalRepository;

import io.sanzharss.relationship.domain.one_to_one.bidirectional.Fingerprint;
import org.springframework.data.repository.CrudRepository;

public interface FingerprintRepository extends CrudRepository<Fingerprint, Long> {
}

