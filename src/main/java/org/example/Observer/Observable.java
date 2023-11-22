package org.example.Observer;

import org.example.Strategy.TaskCompletionStrategy;

public interface Observable {

    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);


    public void notifyObservers(TaskCompletionStrategy action);
}
