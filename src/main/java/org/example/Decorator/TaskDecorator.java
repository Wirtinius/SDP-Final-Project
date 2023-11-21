package org.example.Decorator;

import org.example.Factory.Task;

// TaskDecorator.java
public abstract class TaskDecorator implements Task {
    protected Task decoratedTask;

    public TaskDecorator(Task decoratedTask) {
        this.decoratedTask = decoratedTask;
    }

    @Override
    public String getName() {
        return decoratedTask.getName();
    }

    @Override
    public String getDescription() {
        return decoratedTask.getDescription();
    }

    @Override
    public int getPriority() {
        return decoratedTask.getPriority();
    }

    @Override
    public boolean isCompleted() {
        return decoratedTask.isCompleted();
    }

    @Override
    public String getType() {
        return decoratedTask.getType();
    }
}
