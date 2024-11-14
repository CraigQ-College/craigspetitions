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

    // Adding 2 petitions to start off when the application launches
    public PetitionController() {

        petitions.add(new Petition(UUID.randomUUID().toString(), "Make a Change for Climate Change", " Changing our carbon emissions to more sustainable sources. Going Electric and reducing the Cars on the road. "));
        petitions.add(new Petition(UUID.randomUUID().toString(), "Tell Ronald McDonald its time to retire", " Self Explanatory this one! "));
    }

    // Show form for creating a petition
    @GetMapping("/createPetition")
    public String createPetitionForm() {
        return "createPetition";
    }

    // Handle form submission and create a new petition
    @PostMapping("/createPetition")
    public String createPetition(@RequestParam String title, @RequestParam String description) {
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
