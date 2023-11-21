package org.example.Singleton;

import org.example.Factory.Task;
import org.example.Observer.Observable;
import org.example.Observer.Observer;

import java.util.ArrayList;
import java.util.List;
public class TaskManager implements Observable {
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
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String action) {
        for (Observer observer : observers) {
            observer.update(action);
        }
    }

}
