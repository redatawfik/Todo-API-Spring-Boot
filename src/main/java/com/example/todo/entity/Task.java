package com.example.todo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private Long localTaskId;

    private String title;

    private boolean done;

    public Task() {
    }

    public Task(Long localTaskId, String title, boolean done) {
        this.localTaskId = localTaskId;
        this.title = title;
        this.done = done;
    }

    public Task(Long id, Long localTaskId, String title, boolean done) {
        this.id = id;
        this.localTaskId = localTaskId;
        this.title = title;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocalTaskId() {
        return localTaskId;
    }

    public void setLocalTaskId(Long localTaskId) {
        this.localTaskId = localTaskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
