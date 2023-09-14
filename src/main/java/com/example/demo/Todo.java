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

    // Constructors

    // Other methods if needed
}