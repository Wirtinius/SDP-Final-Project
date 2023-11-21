package org.example;
import org.example.Factory.ComplexTaskFactory;
import org.example.Factory.DailyTaskFactory;
import org.example.Factory.EasyTaskFactory;
import org.example.Factory.Task;
import org.example.Observer.TaskNotify;
import org.example.Singleton.TaskManager;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        TaskManager task = TaskManager.getInstance();
//        System.out.println(task);
//        task.addObserver(new TaskNotify());
        Task complextask = new ComplexTaskFactory().createTask("Complex", "test", 1, "test");
        Task easytask = new EasyTaskFactory().createTask("Easy", "test", 1, "test");
        Task dailytask = new DailyTaskFactory().createTask("Daily", "test", 1, "test");

//        CompletedTask completed_task = new CompletedTask(task1);
//        completed_task.markAsCompleted();
//        task.addTask(task1);
        ConfigDB config = new ConfigDB();
        config.saveTask(easytask);
        config.saveTask(dailytask);
        config.saveTask(complextask);





//        List<Task> tasksFromDatabase = ConfigDB.getTaskList();
//        Integer count = 0;
//        for (Task tasks : tasksFromDatabase) {
//            count ++;
//            System.out.println(count + " | " + tasks.getName() + " | " + tasks.getDescription() + " | " + tasks.isCompleted());
//        }
//         while (true) {
//
//             System.out.println("1. Register\n2. Login\n3. Exit");
//             int choice = scanner.nextInt();
//
//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter username: ");
//                     String regUsername = scanner.next();
//                     System.out.print("Enter password: ");
//                     String regPassword = scanner.next();
////                     userManager.registerUser(regUsername, regPassword);
//                     break;
//
//                 case 2:
//                     System.out.print("Enter username: ");
//                     String loginUsername = scanner.next();
//                     System.out.print("Enter password: ");
//                     String loginPassword = scanner.next();
////                     userManager.loginUser(loginUsername, loginPassword);
//                     break;
//
//                 case 3:
//                     System.exit(0);
//
//                 default:
//                     System.out.println("Invalid choice. Try again.");
//             }
//
//         }
    }
} 
