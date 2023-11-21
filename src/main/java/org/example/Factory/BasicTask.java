package org.example.Factory;

public class BasicTask implements Task {
    private String name;
    private String description;
    private int priority;
    private String deadline;
    private boolean completed;

    public BasicTask(String name, String description, int priority, String deadline) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.completed = false; // By default, a task is not completed
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
    public String getDeadline() {
        return deadline;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String getType() {
        return "Basic";
    }
}
