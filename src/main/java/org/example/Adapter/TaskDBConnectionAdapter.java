package org.example.Adapter;
import org.example.ConfigDB;
import org.example.Factory.Task;
import org.example.Strategy.SaveStrategy;

public class TaskDBConnectionAdapter implements SaveStrategy {
    @Override
    public void save(Task task) {
        ConfigDB.saveTask(task);
    }
}
