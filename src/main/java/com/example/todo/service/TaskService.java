package com.example.todo.service;

import com.example.todo.entity.Task;
import com.example.todo.entity.request.LocalTask;
import com.example.todo.entity.request.RemovedTask;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class TaskService implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> retrieveTasks(String username) {
        return taskRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<List<LocalTask>> getAllTasksByUsername(String username) {
        List<Task> list = retrieveTasks(username);
        List<LocalTask> response = new ArrayList<>();
        for (Task t : list) {
            response.add(new LocalTask(t.getLocalTaskId(), t.getTitle(), t.isDone()));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void removeTasks(RemovedTask[] removedTask, String username) {
        for (RemovedTask task : removedTask) {
            taskRepository.deleteByLocalTaskIdAndUsername(task.getId(), username);
        }
    }

    @Override
    public void addTasks(LocalTask[] request, String username) {
        List<Task> list = retrieveTasks(username);
        for (LocalTask requestTask : request) {
            boolean flag = false;
            for (Task serverTask : list) {
                if (requestTask.getId().equals(serverTask.getLocalTaskId())) {
                    addTask(new Task(serverTask.getId(), username, requestTask.getId(), requestTask.getTitle(), requestTask.isDone()));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                addTask(new Task(username, requestTask.getId(), requestTask.getTitle(), requestTask.isDone()));
            }
        }
    }
}
