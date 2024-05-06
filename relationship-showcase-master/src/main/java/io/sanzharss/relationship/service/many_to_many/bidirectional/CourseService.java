package io.sanzharss.relationship.service.many_to_many.bidirectional;

import io.sanzharss.relationship.domain.many_to_many.bidirectional.Course;
import io.sanzharss.relationship.repository.many_to_many.bidirectionalRepository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CourseService {
    @Autowired
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course save(Course course){
        return courseRepository.save(course);
    }

    public Course update(Long id, Course updateCourse){
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if (optionalCourse.isPresent()){
            Course myCourse = optionalCourse.get();

            myCourse.setName(updateCourse.getName());
            myCourse.setCourseCode(updateCourse.getCourseCode());

            return courseRepository.save(myCourse);
        }else {
          log.warn("Course " + id + " not found!");
        }
        return updateCourse;
    }

    public Course findById(Long id){
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if (optionalCourse.isPresent()){
           return optionalCourse.get();
        }else
            log.warn("Course " + id + " not found!");

        return null;
    }

    public List<Course> findAll(){
        List<Course> courses = new LinkedList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public void delete(Long id){
        courseRepository.deleteById(id);
    }


}
