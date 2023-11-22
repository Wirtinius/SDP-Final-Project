package org.example.Observer;

import org.example.Strategy.TaskCompletionStrategy;

public interface Observer {
    public TaskCompletionStrategy update(TaskCompletionStrategy action);

}
