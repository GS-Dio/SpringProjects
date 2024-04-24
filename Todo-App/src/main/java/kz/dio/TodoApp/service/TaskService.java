package kz.dio.TodoApp.service;

import jakarta.transaction.Transactional;
import kz.dio.TodoApp.domain.Task;
import kz.dio.TodoApp.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);



    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

//    @Transactional
//    public void updateTask(long id, String title, String description) {
//        Optional<Task> a = taskRepository.findById(id);
//        if (a.isEmpty()){
//            logger.warn("Task " + id + " not found!");
//        }else
//            taskRepository.update(id, title, description);
//    }

    public Task findById(long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            logger.warn("Task %d not found!".formatted(id));
            return null;
        }
        return optionalTask.get();
    }

    public List<Task> findAll(){
        List<Task> tasks = new LinkedList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }
    
    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
}
