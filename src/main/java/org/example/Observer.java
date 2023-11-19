package org.example;

// Наблюдатель для отслеживания статуса завершенности тасков
public class Observer {
    public void update(Task task) {
        if (task.isCompleted()) {
            System.out.println("Задача завершена: " + task.getDescription());
        }
    }
}
