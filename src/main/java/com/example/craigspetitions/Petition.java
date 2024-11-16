package com.example.craigspetitions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Petition {
    private String title;
    private String description;
    private LocalDateTime dateCreated;
    private List<Signature> signatures;

    public Petition(String title, String description) {
        this.title = title;
        this.description = description;
        this.dateCreated = LocalDateTime.now();
        this.signatures = new ArrayList<>();
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void addSignature(Signature signature) {
        this.signatures.add(signature);
    }
}

