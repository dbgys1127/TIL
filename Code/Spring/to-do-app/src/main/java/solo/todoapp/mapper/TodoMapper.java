package solo.todoapp.mapper;

import org.springframework.stereotype.Component;
import solo.todoapp.entity.Todo;
import solo.todoapp.entity.dto.TodoPatchDto;
import solo.todoapp.entity.dto.TodoPostDto;
import solo.todoapp.entity.dto.TodoResponseDto;

@Component
public class TodoMapper {
    public Todo toDoPostDtoToToDo(TodoPostDto toDoPostDto){
        return new Todo(0L,
                toDoPostDto.getTitle(),
                toDoPostDto.getOrder(),
                toDoPostDto.getCompleted());
    };
    public Todo toDoPatchDtoToToDo(Long id, TodoPatchDto toDoPatchDto){
        return new Todo(id,
                        toDoPatchDto.getTitle(),
                        toDoPatchDto.getOrder(),
                        toDoPatchDto.getCompleted());
    };
    public TodoResponseDto toDoToToDoResponseDto(Todo toDo){
        return new TodoResponseDto(toDo.getId(),
                toDo.getTitle(),
                toDo.getOrder(),
                toDo.getCompleted());
    };

}
