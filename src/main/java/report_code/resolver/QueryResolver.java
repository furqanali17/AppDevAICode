package report_code.resolver;

import org.springframework.stereotype.Component;
import report_code.entity.Household;
import report_code.entity.Pet;
import report_code.service.HouseholdService;
import report_code.service.PetService;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    private final HouseholdService householdService;
    private final PetService petService;

    public QueryResolver(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }
}
