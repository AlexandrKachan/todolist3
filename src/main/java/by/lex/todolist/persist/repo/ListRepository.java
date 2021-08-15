package by.lex.todolist.persist.repo;

import by.lex.todolist.persist.entity.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends CrudRepository<List, Long> {
}
