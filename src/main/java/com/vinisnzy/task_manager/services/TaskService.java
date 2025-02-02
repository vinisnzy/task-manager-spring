package com.vinisnzy.task_manager.services;

import com.vinisnzy.task_manager.enums.TaskStatus;
import com.vinisnzy.task_manager.exceptions.ResourceNotFoundException;
import com.vinisnzy.task_manager.models.entities.Task;
import com.vinisnzy.task_manager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> getTasks() {
        List<Task> tasks = repository.findAll();
        return tasks;
    }

    public Task getTaskById(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return task;
    }

    public List<Task> getTasksByTitle(String title) {
        List<Task> tasks = repository.findByTitleContaining(title);
        if (tasks.isEmpty()) throw new ResourceNotFoundException(title);
        return tasks;
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        List<Task> tasks = repository.findByStatus(status);
        if (tasks.isEmpty()) throw new ResourceNotFoundException();
        return tasks;
    }

    public List<Task> getTasksByTitleAndStatus(String title, TaskStatus status) {
        List<Task> tasks = repository.findByTitleContainingAndStatus(title, status);
        if (tasks.isEmpty()) throw new ResourceNotFoundException(title);
        return tasks;
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = getTaskById(id);
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setStatus(task.getStatus());
        return repository.save(taskToUpdate);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
