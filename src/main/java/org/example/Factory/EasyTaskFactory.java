package org.example.Factory;

import org.example.Decorator.DailyDecorator;
import org.example.Decorator.EasyDecorator;
import org.example.Factory.Task;
import org.example.Factory.TaskAbstractFactory;

public class EasyTaskFactory extends TaskAbstractFactory {
    @Override
    public Task createTask(String name, String description, Integer priority) {
        return new EasyDecorator(new BasicTask(name, description, priority));
    }
}