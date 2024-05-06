package io.sanzharss.relationship.service.many_to_many.bidirectional;

import io.sanzharss.relationship.domain.many_to_many.bidirectional.Student;
import io.sanzharss.relationship.repository.many_to_many.bidirectionalRepository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student update(Long id, Student updateStudent){
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()){
            Student myStudent = optionalStudent.get();

            myStudent.setName(updateStudent.getName());
            myStudent.setCourses(updateStudent.getCourses());

            return studentRepository.save(myStudent);
        }else
            log.warn("Student " + id + " not found!");

        return updateStudent;
    }

    public Student findById(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()){
            return optionalStudent.get();
        }else
            log.warn("Course " + id + " not found!");

        return null;
    }

    public List<Student> findAll(){
        List<Student> students = new LinkedList<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
