package com.example.craigspetitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class CraigsPetitions {

    private List<Petition> petitions = new ArrayList<>(List.of(
            new Petition("Reduce Reuse Recycle", "Reduce plastic use, change to better alternatives"),
            new Petition("Support Clean Energy", "Join the movement for a sustainable future!")
    ));

    @GetMapping("/")
    public String showAllPetitions(Model model) {
        model.addAttribute("petitions", petitions);
        return "allPetitions";
    }
    @GetMapping("/craigspetitions/createPetition")
    public String createPetition() {
        return "createPetition";
    }

    @GetMapping("/craigspetitions/viewPetition/{title}")
    public String viewPetition(@PathVariable String title, Model model) {
        Petition petition = petitions.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Petition not found"));
        model.addAttribute("petition", petition);
        return "viewPetition";
    }

    @GetMapping("/craigspetitions/signPetition/{title}")
    public String signPetition(@PathVariable String title, Model model) {
        model.addAttribute("title", title);
        return "signPetition";
    }

    @PostMapping("/craigspetitions/submitSignature")
    public String submitSignature(@RequestParam String title, @RequestParam String name) {
        Petition petition = petitions.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Petition not found"));
        petition.addSignature(name); // Assuming Petition has a method to add signatures
        return "redirect:/craigspetitions/";
    }

    public static void main(String[] args) {
        SpringApplication.run(CraigsPetitions.class, args);
    }
}

