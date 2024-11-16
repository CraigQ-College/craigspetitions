package com.example.craigspetitions;

import java.time.LocalDateTime;

public class Signature {
    private String name;
    private LocalDateTime date;

    public Signature(String name) {
        this.name = name;
        this.date = LocalDateTime.now();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }
}

