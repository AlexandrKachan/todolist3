package by.lex.todolist.repr;

import javax.validation.constraints.NotEmpty;

public class ListRepr {

    private Long id;
    @NotEmpty
    private String listName;

    public ListRepr() {
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
