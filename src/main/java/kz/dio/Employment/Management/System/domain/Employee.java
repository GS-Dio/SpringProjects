package kz.dio.Employment.Management.System.domain;

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
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String position;
    private String departament;
    private String contactInfo;
}
