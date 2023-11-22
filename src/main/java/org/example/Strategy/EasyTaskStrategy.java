package org.example.Strategy;

public class EasyTaskStrategy implements TaskCompletionStrategy {
    public TaskCompletionStrategy execute() {
        System.out.println("Task completed created!");
        return null;
    }
}

