package org.example;

@SuppressWarnings("ALL")
public class Signature {
    private final String name;
    private final String email;

    public Signature(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

