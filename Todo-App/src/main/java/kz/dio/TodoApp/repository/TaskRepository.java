package kz.dio.TodoApp.repository;

import jakarta.transaction.Transactional;
import kz.dio.TodoApp.domain.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface TaskRepository extends CrudRepository<Task, Long> {
//    @Transactional
//    @Modifying
//    @Query("UPDATE Task t SET t.title = ?2, t.description = ?3 WHERE t.id = ?1")
//    int update(long id, String title, String description);
}
