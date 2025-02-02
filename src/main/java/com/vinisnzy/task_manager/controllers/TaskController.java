package com.vinisnzy.task_manager.controllers;

import com.vinisnzy.task_manager.enums.TaskStatus;
import com.vinisnzy.task_manager.models.entities.Task;
import com.vinisnzy.task_manager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = service.getTasks();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = service.getTaskById(id);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping(value = "/title/{title}")
    public ResponseEntity<List<Task>> getTasksByTitle(@PathVariable String title) {
        List<Task> tasks = service.getTasksByTitle(title);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping(value = "/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status) {
        List<Task> tasks = service.getTasksByStatus(status);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping(value = "/title/{title}/status/{status}")
    public ResponseEntity<List<Task>> getTasksByTitleAndStatus(@PathVariable String title, @PathVariable TaskStatus status) {
        List<Task> tasks = service.getTasksByTitleAndStatus(title, status);
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task = service.createTask(task);
        return ResponseEntity.ok().body(task);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task = service.updateTask(id, task);
        return ResponseEntity.ok().body(task);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
