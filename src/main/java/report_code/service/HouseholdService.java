package report_code.service;

import org.springframework.stereotype.Service;
import report_code.entity.Household;
import report_code.repository.HouseholdRepository;

import java.util.List;

@Service
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public void deleteHousehold(String eircode) {
        householdRepository.deleteById(eircode);
    }
    public Household getHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode).orElse(null);
    }

}


