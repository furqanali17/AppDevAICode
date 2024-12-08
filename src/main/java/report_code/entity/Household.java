package report_code.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Household {
    @Id
    @NotBlank(message = "Eircode is mandatory")
    private String eircode;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotNull(message = "Number of occupants is mandatory")
    private Integer numberOccupants;

    @NotNull(message = "Maximum number of occupants is mandatory")
    private Integer maxOccupants;

    @NotNull(message = "Owner occupied status is mandatory")
    private Boolean ownerOccupied;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets;

    public Household(String eircode) {
        this.eircode = eircode;
    }
}


