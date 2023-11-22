package org.example.Strategy;
import org.example.Factory.Task;

public interface TaskCompletionStrategy {
    public void execute(Task task);
}