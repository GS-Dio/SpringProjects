package kz.dio.TodoApp.service;

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

    public Task update(long id, Task updateTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task myTask = optionalTask.get();

            myTask.setTitle(updateTask.getTitle());
            myTask.setDescription(updateTask.getDescription());
            myTask.setCompleted(updateTask.isCompleted());

            return taskRepository.save(myTask);
        } else {
          logger.warn("Task " + id + " not found!");
        }
        return updateTask;
    }

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
