package kz.dio.TodoApp.web;

import kz.dio.TodoApp.domain.Task;
import kz.dio.TodoApp.service.TaskService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    public final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable long id, @RequestBody Task task){
        return taskService.update(id, task);
    }

    @GetMapping
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable long id){
        return taskService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        taskService.deleteById(id);
    }


}
