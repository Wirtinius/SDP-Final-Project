package org.example.Factory;

import org.example.Decorator.DailyDecorator;
import org.example.Factory.Task;
import org.example.Factory.TaskAbstractFactory;

public class DailyTaskFactory extends TaskAbstractFactory {
    @Override
    public Task createTask(String name, String description, Integer priority, String deadline) {
        return new DailyDecorator(new BasicTask(name, description, priority, deadline));
    }
}