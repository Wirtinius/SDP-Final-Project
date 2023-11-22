package org.example.Strategy;

import org.example.Factory.Task;

public class ComplexTaskStrategy implements TaskCompletionStrategy {
    public void execute(Task task) {
        System.out.println("Sending notification for completed task: " + task.getName());
    }
}
