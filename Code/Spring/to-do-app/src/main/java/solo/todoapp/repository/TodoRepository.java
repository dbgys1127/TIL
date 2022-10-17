package solo.todoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import solo.todoapp.entity.Todo;


public interface TodoRepository extends JpaRepository<Todo, Long> {

}
