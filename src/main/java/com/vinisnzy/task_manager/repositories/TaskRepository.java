package com.vinisnzy.task_manager.repositories;

import com.vinisnzy.task_manager.enums.TaskStatus;
import com.vinisnzy.task_manager.models.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleContaining(String title);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByTitleContainingAndStatus(String title, TaskStatus status);
}
