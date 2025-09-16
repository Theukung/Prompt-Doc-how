package com.example.todo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main application class for the To-Do List.
 * Handles user interaction and console I/O.
 */
public class ToDoApp {

    private static final ToDoList toDoList = new ToDoList();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    /**
     * Main application loop.
     */
    public static void run() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        listTasks();
                        break;
                    case 3:
                        removeTask();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== To-Do Menu =====");
        System.out.println("1. Add");
        System.out.println("2. List");
        System.out.println("3. Remove");
        System.out.println("4. Exit");
        System.out.println("======================");
    }

    private static void addTask() {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        toDoList.addTask(description);
    }

    private static void listTasks() {
        toDoList.viewTasks();
    }

    private static void removeTask() {
        listTasks(); // Show tasks to help user choose
        System.out.print("Enter the task number to remove: ");
        handleTaskOperation(toDoList::removeTask);
    }

    private static void handleTaskOperation(java.util.function.IntConsumer operation) {
        try {
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            operation.accept(taskNumber);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }
}