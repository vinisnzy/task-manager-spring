package com.vinisnzy.task_manager.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskStatus {
    PENDING("PENDING"),
    DOING("DOING"),
    DONE("DONE");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
