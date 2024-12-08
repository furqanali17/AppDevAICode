package report_code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import report_code.entity.Household;

import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household, String> {
    List<Household> findByPetsIsNull();

    @Query("SELECT h FROM Household h LEFT JOIN FETCH h.pets WHERE h.eircode = :eircode")
    Household findByEircodeWithPets(@Param("eircode") String eircode);
}

