package report_code;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import report_code.entity.Household;
import report_code.entity.Pet;
import report_code.repository.HouseholdRepository;
import report_code.repository.PetRepository;

@SpringBootTest
class ReportCodeApplicationTests {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private HouseholdRepository householdRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreatePet() {
        Household household = new Household();
        household.setEircode("E789");
        household.setAddress("789 Oak St");
        householdRepository.save(household);

        Pet pet = new Pet();
        pet.setName("Rex");
        pet.setHousehold(household);
        petRepository.save(pet);

    }


}
