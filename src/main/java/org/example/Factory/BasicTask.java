package org.example.Factory;

public class BasicTask implements Task {
    private String name;
    private String description;
    private int priority;
    private int type;
    private boolean completed;



    public BasicTask(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String getType() {
        return null;
    }
}
