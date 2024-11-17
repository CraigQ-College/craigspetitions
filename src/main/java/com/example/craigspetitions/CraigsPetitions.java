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

    /**
     * This Creates a pre-populated list for when the application is launched
     */

    private List<Petition> petitions = new ArrayList<>(List.of(
            new Petition("Reduce Reuse Recycle", "Reduce plastic use, change to better alternatives"),
            new Petition("Support Clean Energy", "Join the movement for a sustainable future!")
    ));

    /**
     * This function Displays the list of all petitions on the main page.
     * It adds the list of petitions to the model for rendering in the Thymeleaf template.
     */
    @GetMapping("/")
    public String showAllPetitions(Model model) {
        model.addAttribute("petitions", petitions);
        return "allPetitions";
    }

    /**
     * This function Displays the form for creating a new petition.
     * It returns the name of the Thymeleaf template for petition creation.
     */
    @GetMapping("/createPetition")
    public String createPetition() {
        return "createPetition";
    }

    /**
     * This function Handles the form submission for creating a new petition.
     * It adds the new petition to the list and redirects to the main page.
     */
    @PostMapping("/savePetition")
    public String savePetition(@RequestParam String title, @RequestParam String description) {
        petitions.add(new Petition(title, description));
        return "redirect:/";
    }

    /**
     * This function displays the details of a specific petition, including its title, description, and signatures.
     * It adds the petition to the model for rendering. Redirects to the main page if the petition is not found.
     */
    @GetMapping("/viewPetition/{title}")
    public String viewPetition(@PathVariable String title, Model model) {
        for (Petition petition : petitions) {
            if (petition.getTitle().equalsIgnoreCase(title)) {
                model.addAttribute("petition", petition);
                return "viewPetition";
            }
        }
        return "redirect:/";
    }

    /**
     * This function adds a signature to a specific petition based on its title.
     * It then redirects back to the detailed view of the petition after adding the signature.
     */
    @PostMapping("/addSignature")
    public String addSignature(@RequestParam String title, @RequestParam String name, @RequestParam String email) {
        for (Petition petition : petitions) {
            if (petition.getTitle().equalsIgnoreCase(title)) {
                petition.addSignature(name + " (" + email + ")");
                break;
            }
        }
        return "redirect:/viewPetition/" + title;
    }


    /**
     * This function displays the search page where users can enter a query to search for petitions.
     * It returns the name of the Thymeleaf template for searching petitions.
     */
    @GetMapping("/search")
    public String searchPetitions() {
        return "searchPetitions";
    }

    /**
     * This function processes the search query entered by the user.
     * It filters the list of petitions based on the query and displays the results.
     */
    @GetMapping("/performSearch")
    public String performSearch(@RequestParam String query, Model model) {
        List<Petition> filteredPetitions = new ArrayList<>();
        for (Petition petition : petitions) {
            if (petition.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    petition.getDescription().toLowerCase().contains(query.toLowerCase())) {
                filteredPetitions.add(petition);
            }
        }
        model.addAttribute("petitions", filteredPetitions);
        model.addAttribute("query", query);
        return "searchResults";
    }


    public static void main(String[] args) {
        SpringApplication.run(CraigsPetitions.class, args);
    }
}
