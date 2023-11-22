package org.example.Strategy;

import org.example.Factory.Task;

public class EasyTaskStrategy implements TaskCompletionStrategy {
    public void execute(Task task) {
        System.out.println("Task completed: " + task.getName());
    }
}

