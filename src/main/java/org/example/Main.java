//package org.example;
//import org.example.Factory.ComplexTaskFactory;
//import org.example.Factory.DailyTaskFactory;
//import org.example.Factory.EasyTaskFactory;
//import org.example.Factory.Task;
//import org.example.Observer.TaskNotify;
//import org.example.Singleton.TaskManager;
//import org.example.Strategy.DatabaseSaveStrategy;
//
//import java.util.List;
//import java.util.Scanner;
//
//
//public class Main {
//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
//        TaskManager notifier = TaskManager.getInstance();
////        System.out.println(task);
//        notifier.addObserver(new TaskNotify());
//        notifier.notifyObservers("Task has been created");
//
//        Task complextask = new ComplexTaskFactory().createTask("Complex", "test", 1, "test");
//        Task easytask = new EasyTaskFactory().createTask("Easy", "test", 1, "test");
//        Task dailytask = new DailyTaskFactory().createTask("Daily", "test", 1, "test");
//
//        DatabaseSaveStrategy saver = new DatabaseSaveStrategy();
////        saver.save(easytask);
////        saver.save(complextask);
////        saver.save(dailytask);
//
//
//
//
//
//        List<Task> tasksFromDatabase = ConfigDB.getTaskList();
//        Integer count = 0;
//        for (Task tasks : tasksFromDatabase) {
//            count ++;
//            System.out.println(count + " | " + tasks.getName() + " | " + tasks.getDescription() + " | " + tasks.isCompleted());
//        }
//    }
//}



package org.example;

import org.example.Factory.*;
import org.example.Observer.TaskNotify;
import org.example.Singleton.TaskManager;
import org.example.Strategy.ComplexTaskStrategy;
import org.example.Strategy.DailyTaskStrategy;
import org.example.Strategy.EasyTaskStrategy;
import org.example.Strategy.TaskCompletionStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = TaskManager.getInstance();
        taskManager.addObserver(new TaskNotify());

        List<Task> tasksFromDatabase = ConfigDB.getTaskList();

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Daily Task");
            System.out.println("2. Create Easy Task");
            System.out.println("3. Create Complex Task");
            System.out.println("4. List All Tasks");
            System.out.println("5. List one specific Task");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAndSaveTask(new DailyTaskFactory(), taskManager, scanner, new TaskNotify().update(new DailyTaskStrategy().execute()));
                    break;
                case 2:
                    createAndSaveTask(new EasyTaskFactory(), taskManager, scanner, new TaskNotify().update(new EasyTaskStrategy().execute()));
                    break;
                case 3:
                    createAndSaveTask(new ComplexTaskFactory(), taskManager, scanner, new TaskNotify().update(new ComplexTaskStrategy().execute()));
                    break;
                case 4:
                    listTasks(tasksFromDatabase);
                    break;
                case 5:
                    GetOneTask(scanner);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the program.");
    }

    private static void createAndSaveTask(TaskAbstractFactory taskFactory, TaskManager taskManager,
                                           Scanner scanner, TaskCompletionStrategy taskNotify) {
        Task task = taskFactory.createTask(
                readUserInput("Enter task name: ", scanner),
                readUserInput("Enter task description: ", scanner),
                readUserInputInt("Enter task priority: ", scanner)
        );
        taskManager.addTask(task, taskNotify);
        ConfigDB.saveTask(task);

    }

    private static void GetOneTask(Scanner scanner) {

        Task task = ConfigDB.findTaskByName(readUserInput("Enter task name: ", scanner));
        System.out.println( task.getName() + " | " + task.getDescription() + " | " + task.isCompleted() + " | ");
    }

    private static String readUserInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int readUserInputInt(String prompt, Scanner scanner) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            System.out.print(prompt);
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private static void listTasks(List<Task> tasks) {
        System.out.println("Existing Tasks:");
        Integer count = 0;
        for (Task task : tasks) {
            count++;
            System.out.println(count + " | " + task.getName() + " | " + task.getDescription() + " | " + task.isCompleted() + " | ");
        }
    }


}
