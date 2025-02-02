package com.vinisnzy.task_manager.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Task not found. Id " + id);
    }

    public ResourceNotFoundException(String title) {
        super("Task not found. Title: " + title);
    }

    public ResourceNotFoundException() {
        super("Task not found.");
    }
}
