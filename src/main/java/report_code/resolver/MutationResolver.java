package report_code.resolver;


import org.springframework.stereotype.Component;
import report_code.entity.Household;
import report_code.entity.Pet;
import report_code.service.HouseholdService;
import report_code.service.PetService;


import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    private final HouseholdService householdService;
    private final PetService petService;

    public MutationResolver(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    public Household createHousehold(String eircode, String address, int numberOccupants, int maxOccupants, boolean ownerOccupied) {
        Household household = new Household();
        household.setEircode(eircode);
        household.setAddress(address);
        household.setNumberOccupants(numberOccupants);
        household.setMaxOccupants(maxOccupants);
        household.setOwnerOccupied(ownerOccupied);
        return householdService.createHousehold(household);
    }

    public Pet createPet(String name, String householdEircode) {
        Pet pet = new Pet();
        pet.setName(name);
        Household household = new Household();
        household.setEircode(householdEircode);
        pet.setHousehold(household);
        return petService.createPet(pet);
    }
}
