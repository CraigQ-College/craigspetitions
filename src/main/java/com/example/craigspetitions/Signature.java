package com.example.craigspetitions;

import java.time.LocalDateTime;

public class Signature {
    private String name; // The name of the person signing
    private LocalDateTime date; // The date and time when the signature was added

    // Constructor to initialize a signature with a name and set the current date
    public Signature(String name) {
        this.name = name;
        this.date = LocalDateTime.now();
    }

    // Returns the name of the person signing
    public String getName() {
        return name;
    }

    // Sets the name of the person signing
    public void setName(String name) {
        this.name = name;
    }

    // Returns the date and time of the signature
    public LocalDateTime getDate() {
        return date;
    }
}
