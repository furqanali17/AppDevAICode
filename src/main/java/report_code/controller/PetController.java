package report_code.controller;

import org.springframework.web.bind.annotation.*;
import report_code.entity.Pet;
import report_code.service.PetService;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
@Validated
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public Pet createPet(@Valid @RequestBody Pet pet) {
        return petService.createPet(pet);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }
}
