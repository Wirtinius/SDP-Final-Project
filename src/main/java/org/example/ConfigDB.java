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

                Task task = new BasicTask(name, description, priority);
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

    public static Task findTaskByName(String taskName) {
        Task task = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT * FROM tasks WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, taskName);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Assuming Task class has a constructor that takes ResultSet
                task = new BasicTask(
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("priority")
                );
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return task;
    }


}