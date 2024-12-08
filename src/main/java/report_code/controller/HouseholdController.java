package report_code.controller;

import org.springframework.web.bind.annotation.*;
import report_code.entity.Household;
import report_code.service.HouseholdService;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/households")
@Validated
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public Household createHousehold(@Valid @RequestBody Household household) {
        return householdService.createHousehold(household);
    }

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @DeleteMapping("/{eircode}")
    public void deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
    }
}


