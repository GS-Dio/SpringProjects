package io.sanzharss.relationship.domain.many_to_many.bidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentId;

  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "student_courses",
      joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
      inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"))
  private Set<Course> courses = new HashSet<>();
}
