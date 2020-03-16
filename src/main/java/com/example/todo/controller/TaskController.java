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
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    public void setTaskServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<LocalTask>> getAllTasks(Authentication authentication) {
        System.out.println(authentication.getName());
        List<Task> list = taskService.retrieveTasks();
        List<LocalTask> response = new ArrayList<>();
        for (Task t : list) {
            response.add(new LocalTask(t.getLocalTaskId(), t.getTitle(), t.isDone()));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody LocalTask[] request) {
        List<Task> list = taskService.retrieveTasks();
        for (LocalTask requestTask : request) {
            boolean flag = false;
            for (Task serverTask : list) {
                if (requestTask.getId().equals(serverTask.getLocalTaskId())) {
                    taskService.addTask(new Task(serverTask.getId(), requestTask.getId(), requestTask.getTitle(), requestTask.isDone()));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                taskService.addTask(new Task(requestTask.getId(), requestTask.getTitle(), requestTask.isDone()));
            }
        }

    }

    @PostMapping("/delete")
    public void removeTasks(@RequestBody RemovedTask[] removedTasks){
        taskService.removeTasks(removedTasks);
    }
}
