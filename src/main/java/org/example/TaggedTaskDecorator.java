package org.example;

// Декоратор для добавления метки (тега) к таску
public class TaggedTaskDecorator extends Task {
    private String tag;

    public TaggedTaskDecorator(Task task, String tag) {
        super(task.getName(), task.getDescription(), task.getPriority(), task.getDeadline());
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
