package com.example.craigspetitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
@Controller
public class CraigsPetitions {

    // In-memory list to store petitions
    private final List<Petition> petitions = List.of(
            new Petition("Reduce Reuse Recycle", "Reduce plastic use, change to better alternatives"),
            new Petition("Support Clean Energy", "Join the movement for a sustainable future!")
    );

    // Mapping for the initial landing page (/), which shows all petitions
    @GetMapping("/")
    public String showAllPetitions(Model model) {
        model.addAttribute("petitions", petitions); // Add the list of petitions to the model
        return "allPetitions"; // Render allPetitions.html from the templates folder
    }

    // Mapping for the create petition form (/createPetition)
    @GetMapping("/createPetition")
    public String createPetitionPage() {
        return "createPetition"; // Render createPetition.html from the templates folder
    }

    // Mapping for the view petition page (/viewPetition)
    @GetMapping("/viewPetition")
    public String viewPetitionPage() {
        return "viewPetition"; // Render viewPetition.html from the templates folder
    }

    public static void main(String[] args) {
        SpringApplication.run(CraigsPetitions.class, args);
    }
}
