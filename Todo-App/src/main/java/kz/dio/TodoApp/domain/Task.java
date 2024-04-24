package kz.dio.TodoApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Task {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    private boolean completed;
}