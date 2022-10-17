package solo.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solo.todoapp.entity.Todo;
import solo.todoapp.entity.dto.TodoPatchDto;
import solo.todoapp.entity.dto.TodoPostDto;
import solo.todoapp.entity.dto.TodoResponseDto;
import solo.todoapp.mapper.TodoMapper;
import solo.todoapp.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class TodoController {

    private final TodoService toDoService;
    private final TodoMapper mapper;

    @PostMapping
    public ResponseEntity save(@RequestBody TodoPostDto toDoPostDto) {

        Todo toDo = mapper.toDoPostDtoToToDo(toDoPostDto);

        Todo response =toDoService.createToDo(toDo);

        return new ResponseEntity<>(mapper.toDoToToDoResponseDto(response), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Todo> todos = toDoService.findToDos();

        List<TodoResponseDto> response =
                todos.stream()
                        .map(todo -> mapper.toDoToToDoResponseDto(todo))
                        .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable("id") Long id, @RequestBody TodoPatchDto toDoPatchDto) {

        Todo response = toDoService.findTodo(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patch(@PathVariable("id") Long id,@RequestBody TodoPatchDto toDoPatchDto) {

        Todo toDo = mapper.toDoPatchDtoToToDo(id,toDoPatchDto);
        Todo response = toDoService.updateToDo(id,toDo);
        return new ResponseEntity<>(response, HttpStatus.UPGRADE_REQUIRED);
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        toDoService.deleteToDos();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable("id") Long id) {
        toDoService.deleteToDo(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
