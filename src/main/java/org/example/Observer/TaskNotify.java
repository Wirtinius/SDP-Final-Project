package org.example.Observer;

import org.example.Strategy.ComplexTaskStrategy;
import org.example.Strategy.TaskCompletionStrategy;


public class TaskNotify implements Observer{

    public TaskCompletionStrategy update(TaskCompletionStrategy action) {
        return action;
    }
}
