package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j // Simple logging framework for java
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student findById(Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isEmpty()){
            logger.warn("Student %d not found!".formatted(id));
            return null;
        }
        return studentOptional.get();
    }

    public List<Student> findAll(){
        List<Student> students = new LinkedList<>();
        studentRepository.findAll()
                .forEach(students::add);
        return students;
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

}
