package io.sanzharss.relationship.web.many_to_many.bidirectional;

import io.sanzharss.relationship.domain.many_to_many.bidirectional.Course;
import io.sanzharss.relationship.service.many_to_many.bidirectional.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course save(@RequestBody Course course){
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, Course course){
        return courseService.update(id, course);
    }

    @GetMapping
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable Long id){
        return courseService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        courseService.delete(id);
    }
}
