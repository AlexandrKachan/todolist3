package by.lex.todolist.persist.repo;

import by.lex.todolist.persist.entity.User;
import by.lex.todolist.repr.ToDoRepr;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import by.lex.todolist.persist.entity.ToDo;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    List<ToDoRepr> findToDoByUser_Username(String username);

    List<ToDoRepr> findToDoByUser(User user);
}
