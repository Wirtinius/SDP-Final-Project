package org.example;

// Фабрика для создания тасков
public class TaskFactory {
    public static Task createTask(String name, String description, int priority, String deadline) {
        return new Task(name, description, priority, deadline);
    }
}
