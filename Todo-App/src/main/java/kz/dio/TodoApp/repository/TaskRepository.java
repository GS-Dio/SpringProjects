package kz.dio.TodoApp.repository;

import jakarta.transaction.Transactional;
import kz.dio.TodoApp.domain.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface TaskRepository extends CrudRepository<Task, Long> {
}
