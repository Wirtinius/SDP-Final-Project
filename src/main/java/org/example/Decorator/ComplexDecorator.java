package org.example.Decorator;

import org.example.Factory.Task;

public class ComplexDecorator extends TaskDecorator {
    public ComplexDecorator(Task decoratedTask) {
        super(decoratedTask);
    }

    @Override
    public String getType() {
        return "Complex";
    }
}