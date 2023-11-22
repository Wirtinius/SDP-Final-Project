package org.example.Observer;

import org.example.Strategy.TaskCompletionStrategy;

public interface Observer {
    TaskCompletionStrategy update(TaskCompletionStrategy action);
}
