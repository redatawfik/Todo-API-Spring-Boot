package com.example.todo.service;

import com.example.todo.entity.Task;
import com.example.todo.entity.request.RemovedTask;

import java.util.List;

public interface ITaskService {
    List<Task> retrieveTasks();

    List<String> retrieveTaskTitles();

    String retrieveTaskById(Long id);

    void addTask(Task task);

    void addTasks(Task[] tasks);

    void removeTasks(RemovedTask[] removedTasks);
}
