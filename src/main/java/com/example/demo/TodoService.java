package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public String listTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todo/list";
    }
    public String addTodo(String title) {
        Todo todo = new Todo(title);
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    public String updateTodo(Long id, String newTitle) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setTitle(newTitle);
            todoRepository.save(todo);
        }
        return "redirect:/todos";
    }

    public String deleteTodo(Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    public String reverseComplete(Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setCompleted(!todo.getCompleted());
            todoRepository.save(todo);
        }
        return "redirect:/todos";
    }
}