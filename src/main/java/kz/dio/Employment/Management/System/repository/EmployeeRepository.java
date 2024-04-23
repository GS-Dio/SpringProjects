package kz.dio.Employment.Management.System.repository;

import kz.dio.Employment.Management.System.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
