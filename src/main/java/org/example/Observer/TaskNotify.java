package org.example.Observer;

public class TaskNotify implements Observer {
    public void update(String action) {
        System.out.println(action);
    }
}

