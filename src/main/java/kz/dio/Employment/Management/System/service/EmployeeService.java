package kz.dio.Employment.Management.System.service;
import kz.dio.Employment.Management.System.domain.Employee;
import kz.dio.Employment.Management.System.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }


    public List<Employee> findAll(){
        List<Employee> employees = new LinkedList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }


    public Employee findById(long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
       if(employeeOptional.isEmpty()){
           logger.warn("Employee %d not found!".formatted(id));
           return null;
       }

       return employeeOptional.get();
    }

    public void delete(long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()){
            logger.warn("Employee %d not found!".formatted(id));
        }
        employeeRepository.deleteById(id);
    }
}
