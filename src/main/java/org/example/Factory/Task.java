package org.example.Factory;

public interface Task {
    public abstract String getName();
    public abstract String getDescription();
    public abstract int getPriority();
    public abstract boolean isCompleted();
    public abstract String getType();


//    public void markAsCompleted() {
//        this.isCompleted = true;
//    }


}


















//package org.example.Factory;
//
//public abstract class Task {
//    String name;
//    String description;
//    int priority;
//    String type;
//    boolean is_completed;
//
//    Task (String name, String description, Integer priority, String type){
//        this.name = name;
//        this.description = description;
//        this.priority = priority;
//        this.type = type;
//        this.is_completed = false;
//
//    }
//    public abstract String getName();
//    public abstract String getDescription();
//    public abstract int getPriority();
//    //    public abstract String getDeadline();
//    public abstract boolean isCompleted();
//    public abstract String getType();
//
//
////    public void markAsCompleted() {
////        this.isCompleted = true;
////    }
//

//}
