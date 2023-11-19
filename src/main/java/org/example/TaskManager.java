package org.example;

import java.util.ArrayList;
import java.util.List;

// Updated TaskManager class
public class TaskManager {
    private static TaskManager instance;
    private List<Task> tasks;

    private TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    // Additional methods for managing tasks

    public List<Task> getTasks() {
        return tasks;
    }
}
