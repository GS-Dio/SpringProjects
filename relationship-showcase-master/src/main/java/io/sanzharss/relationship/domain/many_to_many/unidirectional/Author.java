package io.sanzharss.relationship.domain.many_to_many.unidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "authors")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "author_books",
      joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
  private List<Book> book = new ArrayList<>();
}
