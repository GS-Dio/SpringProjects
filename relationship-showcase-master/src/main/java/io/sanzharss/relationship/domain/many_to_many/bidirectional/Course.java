package io.sanzharss.relationship.domain.many_to_many.bidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long courseId;

  private String name;

  private String courseCode;

  @ManyToMany(mappedBy = "courses")
  private Set<Student> students = new HashSet<>();
}
