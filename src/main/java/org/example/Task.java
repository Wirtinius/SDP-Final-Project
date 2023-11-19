package org.example;

import java.sql.ResultSet;

// Базовый класс для тасков
public class Task {
    private String name;
    private String description;
    private int priority;
    private String deadline;
    private boolean isCompleted;

    public Task(String name, String description, int priority, String deadline) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.isCompleted = false;
    }

    public Task(ResultSet resultSet) {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }
}
