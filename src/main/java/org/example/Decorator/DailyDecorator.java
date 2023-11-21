package org.example.Decorator;

import org.example.Factory.Task;

public class DailyDecorator extends TaskDecorator {
    public DailyDecorator(Task decoratedTask) {
        super(decoratedTask);
    }

    @Override
    public String getType() {
        return "Daily";
    }
}