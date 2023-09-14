package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public String listTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todo/list";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @GetMapping("/complete/{id}")
    public String completeTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setCompleted(true);
            todoRepository.save(todo);
        }
        return "redirect:/todos";
    }
}
