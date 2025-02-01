package com.vinisnzy.task_manager.repositories;

import com.vinisnzy.task_manager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleContaining(String title);
    List<Task> findByStatus(String status);
    List<Task> findByTitleContainingAndStatus(String title, String status);
}
