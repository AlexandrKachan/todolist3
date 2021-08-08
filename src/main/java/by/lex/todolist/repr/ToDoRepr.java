package by.lex.todolist.repr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import by.lex.todolist.persist.entity.ToDo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ToDoRepr {

    private Long id;

    @NotEmpty
    private String description;

    private String username;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate targetDate;


    @Value("false")
    private boolean complete;

    @NotEmpty
    private String list;



    public ToDoRepr() {
    }

    public ToDoRepr(Long id, @NotEmpty String description, String username, @NotNull LocalDate targetDate,  Boolean complete, @NotEmpty String list) {
        this.id = id;
        this.description = description;
        this.username = username;
        this.targetDate = targetDate;
        this.complete = complete;
        this.list = list;
    }

    public ToDoRepr(ToDo toDo) {
        this.id = toDo.getId();
        this.description = toDo.getDescription();
        this.targetDate = toDo.getTargetDate();
        this.username = toDo.getUser().getUsername();
        this.complete = toDo.isComplet();
        this.list = toDo.getList();
    }


    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
