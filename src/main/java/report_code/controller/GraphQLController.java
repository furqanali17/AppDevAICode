package report_code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import report_code.entity.Household;
import report_code.entity.Pet;
import report_code.service.HouseholdService;
import report_code.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/graphql")
public class GraphQLController {

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private PetService petService;

    @GetMapping("/households")
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping("/household")
    public Household createHousehold(@RequestParam String eircode, @RequestParam String address,
                                     @RequestParam int numberOccupants, @RequestParam int maxOccupants,
                                     @RequestParam boolean ownerOccupied) {
        Household household = new Household();
        household.setEircode(eircode);
        household.setAddress(address);
        household.setNumberOccupants(numberOccupants);
        household.setMaxOccupants(maxOccupants);
        household.setOwnerOccupied(ownerOccupied);
        return householdService.createHousehold(household);
    }

    @PostMapping("/pet")
    public Pet createPet(@RequestParam String name, @RequestParam String householdEircode) {
        Pet pet = new Pet();
        pet.setName(name);
        Household household = householdService.getHouseholdByEircode(householdEircode);
        pet.setHousehold(household);
        return petService.createPet(pet);
    }
}
