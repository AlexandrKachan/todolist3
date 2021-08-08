package by.lex.todolist.controllers;

import by.lex.todolist.security.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import by.lex.todolist.controllers.except.ResourceNotFoundException;
import by.lex.todolist.repr.ToDoRepr;
import by.lex.todolist.service.ToDoService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TodoController {

    private ToDoService toDoService;

    @Autowired
    public TodoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("")
    public String mainPage() {
        return "redirect:/todo/all";
    }

    @GetMapping("/todo/all")
    public String allTodosPage(Model model) {
        List<ToDoRepr> todos = Utils.getCurrentUser()
                .map(toDoService::findToDoByUser_Username)
                .orElseThrow(IllegalStateException::new);
        model.addAttribute("todos", todos);
        return "todoList";
    }

    @GetMapping("/todo/{id}")
    public String todoPage(@PathVariable("id") Long id, Model model) {
        ToDoRepr toDoRepr = toDoService.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("todo", toDoRepr);
        return "todo";
    }

    @GetMapping("/todo/create")
    public String createTodoPage(Model model) {
        model.addAttribute("todo", new ToDoRepr());
        return "todo";
    }

    @PostMapping("/todo/create")
    public String createTodoPost(@ModelAttribute("todo") @Valid ToDoRepr toDoRepr,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }

        toDoService.save(toDoRepr);
        return "redirect:/";
    }

    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        toDoService.delete(id);
        return "redirect:/";
    }
}
