package org.example;

// Строитель для тасков
public class TaskBuilder {
    private String name;
    private String description;
    private int priority;
    private String deadline;

    public TaskBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public TaskBuilder setDeadline(String deadline) {
        this.deadline = deadline;
        return this;
    }

    public Task build() {
        return new Task(name, description, priority, deadline);
    }
}
