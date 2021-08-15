package by.lex.todolist.service;

import by.lex.todolist.persist.entity.List;
import by.lex.todolist.persist.repo.ListRepository;
import by.lex.todolist.repr.ListRepr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ListService {
    private final ListRepository listRepository;

    @Autowired
    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public void create(ListRepr listRepr) {
        List list = new List();
        list.setListName(listRepr.getListName());
        this.listRepository.save(list);
    }
}