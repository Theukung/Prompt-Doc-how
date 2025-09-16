package com.example.todo;

/**
 * Represents a single task in the to-do list.
 */
public class Task {
    private final String description;

    /**
     * Constructs a new Task with the given description.
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}