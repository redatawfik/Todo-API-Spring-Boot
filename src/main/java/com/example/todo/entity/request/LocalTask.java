package com.example.todo.entity.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class LocalTask {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private boolean done;

    public LocalTask() {
    }

    public LocalTask(Long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
