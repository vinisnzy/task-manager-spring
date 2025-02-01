package com.vinisnzy.task_manager.services;

import com.vinisnzy.task_manager.exceptions.ResourceNotFoundException;
import com.vinisnzy.task_manager.models.entities.Task;
import com.vinisnzy.task_manager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Task> getTasksByTitle(String title) {
        return taskRepository.findByTitleContaining(title);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksByTitleAndStatus(String title, String status) {
        return taskRepository.findByTitleContainingAndStatus(title, status);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = getTaskById(id);
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setStatus(task.getStatus());
        return taskRepository.save(taskToUpdate);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
