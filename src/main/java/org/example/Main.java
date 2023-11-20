package org.example;
import java.util.List;
import java.io.ObjectInputFilter.Config;
import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager task = TaskManager.getInstance();
        System.out.println(task);
        task.addObserver(new TaskNotify());
        Task task1 = TaskFactory.createTask("AlEN", "test", 1, "test");

        task.addTask(task1);
        ConfigDB config = new ConfigDB();
//        config.saveTask(task1);

        List<Task> tasksFromDatabase = ConfigDB.getTaskList();
        Integer count = 0;
        for (Task tasks : tasksFromDatabase) {
            count ++;
            System.out.println(count + " | " + tasks.getName() + " | " + tasks.getDescription());
        }
         while (true) {
            
             System.out.println("1. Register\n2. Login\n3. Exit");
             int choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                     System.out.print("Enter username: ");
                     String regUsername = scanner.next();
                     System.out.print("Enter password: ");
                     String regPassword = scanner.next();
                     userManager.registerUser(regUsername, regPassword);
                     break;

                 case 2:
                     System.out.print("Enter username: ");
                     String loginUsername = scanner.next();
                     System.out.print("Enter password: ");
                     String loginPassword = scanner.next();
                     userManager.loginUser(loginUsername, loginPassword);
                     break;

                 case 3:
                     System.exit(0);

                 default:
                     System.out.println("Invalid choice. Try again.");
             }

         }
    }
} 
