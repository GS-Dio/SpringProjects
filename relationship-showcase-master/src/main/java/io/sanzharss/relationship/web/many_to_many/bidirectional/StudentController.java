package io.sanzharss.relationship.web.many_to_many.bidirectional;


import io.sanzharss.relationship.domain.many_to_many.bidirectional.Student;
import io.sanzharss.relationship.service.many_to_many.bidirectional.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student){
        return studentService.update(id,student);
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findByid(@PathVariable Long id){
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
}
