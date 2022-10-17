package solo.todoapp.entity.dto;

import lombok.*;



@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponseDto {
    private Long id;

    private String title;

    private int order;

    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
