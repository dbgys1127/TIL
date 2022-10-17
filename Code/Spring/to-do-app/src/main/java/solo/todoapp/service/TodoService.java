package solo.todoapp.service;

import org.springframework.stereotype.Service;
import solo.todoapp.entity.Todo;
import solo.todoapp.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository toDoRepository;

    public TodoService(TodoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    public Todo createToDo(Todo toDo) {
        Todo savedTodo = toDoRepository.save(toDo);
        return savedTodo;
    }

    public List<Todo> findToDos() {
        List<Todo> todos = toDoRepository.findAll();
        return todos;
    }

    public Todo findTodo(Long id) {
        Optional<Todo> optionalToDo = toDoRepository.findById(id);

        Todo findTodo = optionalToDo.orElseThrow(() -> new NullPointerException());
        return findTodo;
    }


    public Todo updateToDo(Long id, Todo toDo) {
        Todo findTodo = this.findTodo(id);

        Optional.ofNullable(toDo.getTitle()).ifPresent(title-> findTodo.setTitle(title));
        Optional.ofNullable(toDo.getOrder()).ifPresent(order-> findTodo.setOrder(order));
        Optional.ofNullable(toDo.getCompleted()).ifPresent(completed-> findTodo.setCompleted(completed));

        return toDoRepository.save(findTodo);
    }


    public void deleteToDos() {
        toDoRepository.deleteAll();
    }

    public void deleteToDo(Long id) {
        Todo findTodo = this.findTodo(id);
        toDoRepository.delete(findTodo);
    }
}
