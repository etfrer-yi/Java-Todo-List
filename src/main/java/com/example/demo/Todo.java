package com.example.demo;

// These imports were a headache - before they were javax.persistence.[...], but they had to be renamed to jakarta
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;

    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public Todo(String title) {
        this.title = title;
        this.completed = false;
    }

    public Todo() {}

    public String getTitle() {
        return this.title;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setCompleted(boolean status) {
        this.completed = status;
    }

    public Long getId() {
        return this.id;
    }

}