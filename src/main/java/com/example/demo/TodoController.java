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
        Todo todo = new Todo(title);
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @PutMapping("/put/{id}")
    public String updateTodo(@PathVariable Long id, String newTitle) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setTitle(newTitle);
            todoRepository.save(todo);
        }
        return "redirect:/todos";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @PutMapping("/complete/{id}")
    public String reverseComplete(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setCompleted(!todo.getCompleted());
            todoRepository.save(todo);
        }
        return "redirect:/todos";
    }
}
