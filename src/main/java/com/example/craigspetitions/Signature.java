package com.example.craigspetitions;

import java.time.LocalDateTime;

public class Signature {
    private String name; // The name of the person signing
    private String email; // The date and time when the signature was added

    // Constructor to initialize a signature with a name and set the current date
    public Signature(String name, String email ) {
        this.name = name;
        this.email = email;
    }

    // Returns the name of the person signing
    public String getName() {
        return name;
    }

    // Sets the name of the person signing
    public void setName(String name) {
        this.name = name;
    }

    // Returns the email of the person signing
    public String getEmail() {
        return email;
    }

    // Sets the email of the person signing
    public void setEmail(String email) {
        this.name = email;
    }
}