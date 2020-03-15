package com.example.todo.service;

import com.example.todo.entity.Task;
import com.example.todo.entity.request.RemovedTask;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class TaskService implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> retrieveTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<String> retrieveTaskTitles() {
        return null;
    }

    @Override
    public String retrieveTaskById(Long id) {
        return null;
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void addTasks(Task[] tasks) {
        taskRepository.deleteAll();
        List<Task> taskList = Arrays.asList(tasks);
        taskRepository.saveAll(taskList);
    }

    @Override
    public void removeTasks(RemovedTask[] removedTask) {
        for(RemovedTask task: removedTask){
            taskRepository.deleteByLocalTaskId(task.getId());
        }
    }
}
