package com.example.craigspetitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@SpringBootApplication
@RestController
public class CraigsPetitions {

    // Creating the list top store the list of petitions

    private List<Petition> petitions = List.of(
            new Petition("Reduce Reuse Recycle", "Reduce plastic use, change to better alternatives"),
            new Petition("Support Clean Energy", "Join the movement for a sustainable future!")
    );

    // Creating the mapping for all petitions. This will be the initial landing page.

    @GetMapping("/")
    public String showAllPetitions() {
        return "allPetitions";
    }

    // Creating the mapping for the create petition form.

    @GetMapping("createPetition")
    public String createPetitions() {
        return "createPetition";
    }

    // Creating the mapping for users to view petitions.

    @GetMapping("viewPetition")
    public String viewPetition() {
        return "viewPetition";
    }

    public static void main(String[] args) {
        SpringApplication.run(CraigsPetitions.class, args);
    }
}
