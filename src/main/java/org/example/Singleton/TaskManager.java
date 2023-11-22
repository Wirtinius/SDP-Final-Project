package org.example.Singleton;

import org.example.Factory.Task;
import org.example.Observer.Observable;
import org.example.Observer.Observer;
import org.example.Strategy.TaskCompletionStrategy;

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

    public void addTask(Task task, TaskCompletionStrategy taskNotify) {
        tasks.add(task);
        notifyObservers(taskNotify);
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

    @Override
    public void notifyObservers(TaskCompletionStrategy action) {
        for (Observer observer : observers) {
            observer.update(action);
        }
    }

}
