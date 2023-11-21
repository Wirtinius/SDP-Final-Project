package org.example.Strategy;

import org.example.Adapter.TaskDBConnectionAdapter;
import org.example.Factory.Task;

public class DatabaseSaveStrategy implements SaveStrategy {
    @Override
    public void save(Task task) {
        SaveStrategy adapter = new TaskDBConnectionAdapter();
        adapter.save(task);
    }
}
