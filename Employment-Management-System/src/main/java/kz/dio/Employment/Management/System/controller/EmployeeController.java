package kz.dio.Employment.Management.System.controller;

import kz.dio.Employment.Management.System.domain.Employee;
import kz.dio.Employment.Management.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController{
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable long id, @RequestBody Employee employee){
        return employeeService.update(id,employee);
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id){
        return employeeService.findById(id);
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        employeeService.delete(id);
    }
}
