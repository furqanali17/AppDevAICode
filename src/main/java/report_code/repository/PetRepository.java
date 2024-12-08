package report_code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import report_code.entity.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    // Find all pets by household eircode
    List<Pet> findByHouseholdEircode(String eircode);

    // Find pets by name
    List<Pet> findByName(String name);

}
