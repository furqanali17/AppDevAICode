package report_code.service;

import org.springframework.stereotype.Service;
import report_code.entity.Pet;
import report_code.repository.PetRepository;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
