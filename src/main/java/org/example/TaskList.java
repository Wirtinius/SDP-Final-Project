package org.example;

import java.util.ArrayList;
import java.util.List;

// Компоновщик для группировки тасков
public class TaskList extends Task {
    private List<Task> tasks = new ArrayList<>();

    public TaskList(String name, String description) {
        super(name, description, 0, null);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public boolean isCompleted() {
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                return false;
            }
        }
        return true;
    }
}