package org.example.Strategy;

public class ComplexTaskStrategy implements TaskCompletionStrategy {
    public TaskCompletionStrategy execute() {
        System.out.println("Complex Task created!" );
        return null;
    }
}
