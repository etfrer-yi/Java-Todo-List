package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String listTodos(Model model) {
        return todoService.listTodos(model);
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String title) {
        return todoService.addTodo(title);
    }

    @PutMapping("/put/{id}")
    public String updateTodo(@PathVariable("id") Long id, String newTitle) {
        return todoService.updateTodo(id, newTitle);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        return this.todoService.deleteTodo(id);
    }

    @PutMapping("/status/{id}")
    public String reverseComplete(@PathVariable("id") Long id) {
        return this.todoService.reverseComplete(id);
    }
}
