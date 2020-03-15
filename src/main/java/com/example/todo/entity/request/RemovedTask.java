package com.example.todo.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RemovedTask {

    @JsonProperty
    private Long id;

    public RemovedTask() {
    }

    public RemovedTask(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
