package org.example;

import java.util.ArrayList;
import java.util.List;
// Singleton для управления регистрацией студентов
public class TaskManager {
    private static TaskManager instance;
    private List<Task> tasks;

    private TaskManager() {
        tasks = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers("New task created: " + task.getName());
    }

    // Паттерн Observer
    private List<TaskNotify> observers = new ArrayList<>();

    public void addObserver(TaskNotify observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskNotify observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String action) {
        for (TaskNotify observer : observers) {
            observer.update(action);
        }
    }
}
