package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PetitionController {

    private final List<Petition> petitions = new ArrayList<>();

    // Constructor to add sample petitions
    public PetitionController() {
        petitions.add(new Petition(UUID.randomUUID().toString(), "Make a Change for Climate Change",
                "Changing our carbon emissions to more sustainable sources. Going Electric and reducing the Cars on the road."));
        petitions.add(new Petition(UUID.randomUUID().toString(), "Tell Ronald McDonald it's time to retire",
                "Self-explanatory, this one!"));
    }

    // Show form for creating a petition
    @GetMapping("/createPetition")
    public String createPetitionForm() {
        return "createPetition";
    }

    @PostMapping("/createPetition")
    public String createPetition(@RequestParam("title") String title, @RequestParam("description") String description) {
        System.out.println("Received petition with title: " + title + ", description: " + description);
        Petition petition = new Petition(UUID.randomUUID().toString(), title, description);
        petitions.add(petition);
        return "redirect:/allPetitions";
    }


    // Display all petitions
    @GetMapping("/allPetitions")
    public String getAllPetitions(Model model) {
        model.addAttribute("petitions", petitions);
        return "allPetitions";
    }
}
