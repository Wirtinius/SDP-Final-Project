package org.example.Factory;

public abstract class TaskAbstractFactory{
    public abstract Task createTask(String name, String description, Integer priority, String deadline);
}