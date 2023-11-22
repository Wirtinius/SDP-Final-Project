package org.example.Strategy;

public class DailyTaskStrategy implements TaskCompletionStrategy {
    public TaskCompletionStrategy execute() {
        System.out.println("Daily task created!");
        return null;
    }
}
