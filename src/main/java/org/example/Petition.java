package org.example;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Petition {
    private String id;
    private String title;
    private String description;
    private List<Signature> signatures;

    public Petition(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.signatures = new ArrayList<>();
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }
}
