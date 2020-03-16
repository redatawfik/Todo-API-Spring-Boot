package com.example.todo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "localTaskId")
    @NotNull
    private Long localTaskId;

    @Column(name = "title")
    private String title;

    @Column(name = "done")
    private boolean done;

    public Task() {
    }

    public Task(String username, Long localTaskId, String title, boolean done) {
        this.username = username;
        this.localTaskId = localTaskId;
        this.title = title;
        this.done = done;
    }

    public Task(Long id, String username, Long localTaskId, String title, boolean done) {
        this.id = id;
        this.username = username;
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

    public String getUserId() {
        return username;
    }

    public void setUserId(String username) {
        this.username = username;
    }
}
