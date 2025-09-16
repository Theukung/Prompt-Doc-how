package com.example.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the collection of tasks.
 */
public class ToDoList {
    private final List<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the list.
     * @param description The description of the new task.
     */
    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added: " + description);
    }

    /**
     * Displays the tasks in the list to the console.
     */
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
            return;
        }
        System.out.println("\n--- Your To-Do List ---");
        for (int i = 0; i < tasks.size(); i++) {
            // Display with 1-based numbering for user-friendliness
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("-----------------------");
    }

    public void removeTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task removed: " + removedTask.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }
}