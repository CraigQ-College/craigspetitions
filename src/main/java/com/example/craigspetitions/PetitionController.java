package com.example.craigspetitions;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class PetitionController {

	private List<Petition> petitions = new ArrayList<>();

	@RequestMapping("/")
	public List<Petition> getAllPetitions() {
		return petitions;
	}

	@RequestMapping("/viewPetition/{title}")
	public Petition viewPetition(@PathVariable String title) {
		return petitions.stream()
				.filter(petition -> petition.getTitle().equalsIgnoreCase(title))
				.findFirst()
				.orElse(null);
	}

	@PostMapping("/signPetition/{title}")
	public String signPetition(@PathVariable String title, @RequestParam String name) {
		Petition petition = petitions.stream()
				.filter(p -> p.getTitle().equalsIgnoreCase(title))
				.findFirst()
				.orElse(null);

		if (petition != null) {
			petition.addSignature(new Signature(name));
			return "Signature added successfully!";
		}
		return "Petition not found!";
	}

	@PostMapping("/createPetition")
	public String createPetition(@RequestParam String title, @RequestParam String description) {
		petitions.add(new Petition(title, description));
		return "Petition created successfully!";
	}

	@GetMapping("/searchPetitions")
	public List<Petition> searchPetitions(@RequestParam String query) {
		return petitions.stream()
				.filter(p -> p.getTitle().toLowerCase().contains(query.toLowerCase()))
				.collect(Collectors.toList());
	}

	@GetMapping("/createPetition")
	public String createPetitionPage() {
		return "createPetition";
	}

	@PostMapping("/savePetition")
	public String savePetition(@RequestParam String title, @RequestParam String description) {
		Petition newPetition = new Petition(title, description);
		petitions.add(newPetition); // Add the new petition to the in-memory list
		return "redirect:/"; // Redirect back to the allPetitions page
	}


}

