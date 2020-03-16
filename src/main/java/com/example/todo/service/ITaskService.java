package com.example.todo.service;

import com.example.todo.entity.Task;
import com.example.todo.entity.request.LocalTask;
import com.example.todo.entity.request.RemovedTask;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITaskService {
    List<Task> retrieveTasks(String username);

    void addTask(Task task);

    void removeTasks(RemovedTask[] removedTasks, String username);

    void addTasks(LocalTask[] request, String name);

    ResponseEntity<List<LocalTask>> getAllTasksByUsername(String name);
}
