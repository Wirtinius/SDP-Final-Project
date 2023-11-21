package org.example.Decorator;

import org.example.Factory.Task;

public class EasyDecorator extends TaskDecorator {
    public EasyDecorator(Task decoratedTask) {
        super(decoratedTask);
    }

    @Override
    public String getType() {
        return "Easy";
    }
}