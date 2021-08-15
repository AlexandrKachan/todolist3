package by.lex.todolist.persist.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private LocalDate targetDate;

    @Column
    @Value("false")
    private boolean complet;

    @Column
        private String list;



//    @OneToMany(
//            mappedBy = "todo",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//private List<by.lex.todolist.persist.entity.List> lists;
//
//
//    public List<by.lex.todolist.persist.entity.List> getLists() {
//        return lists;
//    }
//
//    public void setLists(List<by.lex.todolist.persist.entity.List> lists) {
//        this.lists = lists;
//    }
//
//    public ToDo() {
//    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public boolean isComplet() {
        return complet;
    }

    public void setComplet(boolean complet) {
        this.complet = complet;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
