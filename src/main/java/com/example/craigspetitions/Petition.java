package com.example.craigspetitions;

import java.util.ArrayList;
import java.util.List;

public class Petition {

    private String title; // The title of the petition
    private String description; // The description of the petition
    private List<Signature> signatures = new ArrayList<>(); // List of signatures for the petition

    // Constructor to initialize a petition with a title and description
    public Petition(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Returns the title of the petition
    public String getTitle() {
        return title;
    }

    // Returns the description of the petition
    public String getDescription() {
        return description;
    }

    // Returns the list of signatures for the petition
    public List<Signature> getSignatures() {
        return signatures;
    }

    // Adds a signature to the petition
    public void addSignature(Signature signature) {
        signatures.add(signature);
    }
}
