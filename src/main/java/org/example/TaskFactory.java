package org.example;

public class TaskFactory {
    public static Task createTask(String name, String description, int priority, String deadline) {
        return new Task(name, description, priority, deadline);
    }
}
