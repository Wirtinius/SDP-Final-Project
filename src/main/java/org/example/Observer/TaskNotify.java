package org.example.Observer;

import org.example.Strategy.ComplexTaskStrategy;
import org.example.Strategy.TaskCompletionStrategy;


public class TaskNotify implements Observer{

    public TaskCompletionStrategy update(TaskCompletionStrategy action) {
        return action;
    }
    private TaskCompletionStrategy completionStrategy;

    public void ComplexNotify() {
        new ComplexTaskStrategy();
    }

    public void EasyNotify(TaskCompletionStrategy completionStrategy) {
            this.completionStrategy = completionStrategy;
    }
    public void DailyNotify(TaskCompletionStrategy completionStrategy) {
            this.completionStrategy = completionStrategy;
    }

}
