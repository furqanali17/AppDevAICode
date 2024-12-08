package report_code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import report_code.entity.Household;
import report_code.repository.HouseholdRepository;
import report_code.service.HouseholdService;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class HouseholdServiceTest {

    @Mock
    private HouseholdRepository householdRepository;

    @InjectMocks
    private HouseholdService householdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createHousehold() {
        Household household = new Household();
        household.setEircode("E123");
        household.setAddress("123 Main St");

        when(householdRepository.save(any(Household.class))).thenReturn(household);

        Household createdHousehold = householdService.createHousehold(household);

        assertNotNull(createdHousehold);
        assertEquals("E123", createdHousehold.getEircode());
        assertEquals("123 Main St", createdHousehold.getAddress());
    }

    @Test
    void getAllHouseholds() {
        Household household1 = new Household();
        household1.setEircode("E123");
        household1.setAddress("123 Main St");

        Household household2 = new Household();
        household2.setEircode("E456");
        household2.setAddress("456 Elm St");

        when(householdRepository.findAll()).thenReturn(List.of(household1, household2));

        List<Household> households = householdService.getAllHouseholds();

        assertNotNull(households);
        assertEquals(2, households.size());
    }

    @Test
    void deleteHousehold() {
        Household household = new Household();
        household.setEircode("E123");

        when(householdRepository.findById("E123")).thenReturn(Optional.of(household));
        doNothing().when(householdRepository).deleteById("E123");

        householdService.deleteHousehold("E123");

        verify(householdRepository, times(1)).deleteById("E123");
    }
}

