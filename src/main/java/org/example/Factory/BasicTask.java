package org.example.Factory;

public class BasicTask implements Task {
    private String name;
    private String description;
    private int priority;
    private int type;
    private boolean completed;



    public BasicTask(String name, String description, int priority, String type) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.completed = false;
        this.type = type;
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
        return type;
    }
}
