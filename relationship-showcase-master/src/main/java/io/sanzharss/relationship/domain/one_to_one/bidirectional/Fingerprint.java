package io.sanzharss.relationship.domain.one_to_one.bidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "fingerprint")
public class Fingerprint {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String texture;
  @OneToOne(mappedBy = "fingerprint")
  private Person person;
}
