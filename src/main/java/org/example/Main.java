package org.example;

public class Main {
    public static void main(String[] args) {
        // Пример использования Composite Pattern

        // Создаем задачи
        Task task1 = new Task("first", "Описание задачи 1", 2, "2023-12-01");
        Task task2 = new Task("second", "Описание задачи 2", 1, "2023-12-15");
        Task task3 = new Task("third", "Описание задачи 3", 3, "2023-12-31");
        ConfigDB configDB = new ConfigDB();
        configDB.save(task1);
        System.out.println(configDB.getTasks());
    }
}