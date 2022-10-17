package solo.todoapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column
    private String title;

    @Column(name="orders")
    private int order;

    @Column
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

    protected Todo() {
    }

    public Todo(Long id, String title, int order, boolean completed) {
        this.id = id;
        this.title = title;
        this.order = order;
        this.completed = completed;
    }
}
