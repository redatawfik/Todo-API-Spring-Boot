package com.example.todo.controller;

import com.example.todo.entity.Task;
import com.example.todo.entity.request.LocalTask;
import com.example.todo.entity.request.RemovedTask;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    public void setTaskServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<LocalTask>> getAllTasks(Authentication authentication) {
        return taskService.getAllTasksByUsername(authentication.getName());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTasks(@RequestBody LocalTask[] request, Authentication authentication) {
        taskService.addTasks(request, authentication.getName());
        return ResponseEntity.ok("Successful add tasks!");
    }

    @PostMapping("/delete")
    public void removeTasks(@RequestBody RemovedTask[] removedTasks, Authentication authentication) {
        taskService.removeTasks(removedTasks, authentication.getName());
    }
}
