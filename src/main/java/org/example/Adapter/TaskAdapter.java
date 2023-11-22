package org.example.Adapter;
import org.example.Factory.Task;

public class TaskAdapter implements TaskAdapterInterface {

    private Task task;

    public TaskAdapter(Task task) {
        this.task = task;
    }


    @Override
    public boolean isCompleted() {
        return true;
    }
}

