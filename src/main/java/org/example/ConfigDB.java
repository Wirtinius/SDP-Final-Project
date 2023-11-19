package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConfigDB {
//    private static final String CONFIG_FILE = "../../../resources/DB.properties";

    private String url;
    private String user;
    private String password;
    private String insertQuery;

    public ConfigDB() {

        loadConfig();
    }

    private void loadConfig() {
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
//            Properties prop = new Properties();
//            if (input == null) {
//                System.out.println("Sorry, unable to find " + CONFIG_FILE);
//                return;
//            }
//            prop.load(input);

            url = "jdbc:postgresql://localhost:5432/SDP";
            user = "postgres";
            password = "Infinitive";
            insertQuery = "insertQuery";

//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    public void save(Task task) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDeadline());
            statement.setInt(4, task.getPriority());
            statement.setBoolean(5, task.isCompleted());

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM tasks";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Assuming Task class has a constructor that takes ResultSet
                Task task = new Task(resultSet);
                tasks.add(task);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tasks;
    }

    // ... (other methods)


    // Method for getting a task by its ID
    public Task getTaskById(int taskId) {
        Task task = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM tasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Extract attributes from the ResultSet and set them in the Task object
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String deadline = resultSet.getString("deadline");
                int priority = resultSet.getInt("priority");
                boolean isCompleted = resultSet.getBoolean("is_completed");

                task = new Task(name, description, priority, deadline);
//                task.setCompleted(isCompleted);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return task;
    }


    // Method for updating a task
//    public void updateTask(Task task) {
//        try {
//            Connection connection = DriverManager.getConnection(url, user, password);
//
//            String sql = "UPDATE tasks SET name=?, description=?, deadline=?, priority=?, is_completed=? WHERE id=?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, task.getName());
//            statement.setString(2, task.getDescription());
//            statement.setString(3, task.getDeadline());
//            statement.setInt(4, task.getPriority());
//            statement.setBoolean(5, task.isCompleted());
//            statement.setInt(6, task.getId()); // Assuming Task class has an ID attribute
//
//            statement.executeUpdate();
//
//            statement.close();
//            connection.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    // Method for deleting a task by its ID
//    public void deleteTask(int taskId) {
//        try {
//            Connection connection = DriverManager.getConnection(url, user, password);
//
//            String sql = "DELETE FROM tasks WHERE id=?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, taskId);
//
//            statement.executeUpdate();
//
//            statement.close();
//            connection.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
