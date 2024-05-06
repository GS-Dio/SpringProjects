package io.sanzharss.relationship.domain.one_to_one.unidirectional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "countries", uniqueConstraints = {
    @UniqueConstraint(name = "CountryNameUniqueConstraint", columnNames = {"name"})
})
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  /**
   * @OneToOne => used to define one-to-one relationship. Parent is Country.
   * @JoinColumn => Foreign key, it means extra column capital_id, would be created in 'countries' table
   *
   * FetchType.EAGER = fetch details of Parent and Child entity too, i.e. Country and Capital
   * FetchType.LAZY = fetch details of Parent only, i.e Country only where Capital details are ignored
   *
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "capital_id", referencedColumnName = "id")
  private Capital capital;
}
