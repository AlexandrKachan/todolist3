package by.lex.todolist.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO rename
@Entity
@Table(
        name = "list"
)
public class List {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            unique = true,
            nullable = false
    )
    private String listName;

    public List() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListName() {
        return this.listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
