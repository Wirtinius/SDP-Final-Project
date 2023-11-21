package org.example;

import org.example.Factory.BasicTask;
import org.example.Factory.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ConfigDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/SDP";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Infinitive";

    public static void saveTask(Task task) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO tasks (name, description, priority, type, is_completed) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setInt(3, task.getPriority());
            statement.setString(4, task.getType());
            statement.setBoolean(5, task.isCompleted());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Task is successfully added");
            }

            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

     public static void getTasks() {

         try {
             Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM  tasks");
             while (result.next()) {
                 String name = result.getString("name");
                 String description = result.getString("description");
                 Integer priority = result.getInt("priority");
                 Boolean isCompleted = result.getBoolean("is_completed");
                 String type = result.getString("type");
                 String created_time_str = result.getString("created_time_str");


                 System.out.println(name + "\t\t" + description + "\t\t" + priority + "\t\t"  + "\t\t" + isCompleted + "\t\t" + created_time_str);
             }
             connection.close();
         }
         catch (Exception ex) {
             ex.printStackTrace();
         }

     }


    public static List<Task> getTaskList() {
        List<Task> tasks = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT * FROM tasks";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                String description = result.getString("description");
                Integer priority = result.getInt("priority");
                Task task = new Task(name, description, priority);
                tasks.add(task);
            }

            result.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tasks;
    }

}