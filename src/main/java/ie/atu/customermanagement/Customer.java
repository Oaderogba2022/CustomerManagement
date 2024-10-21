package ie.atu.customermanagement;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    private int customerId;

    @Min(2)
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;

    @Min(2)
    @NotBlank(message = "First Name cannot be blank")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    @Max(10)
    private int phoneNumber;

    @Past(message = "Must not be in future date")
    private String dateOfBirth;

    @Pattern(regexp = "^[A-Za-z]\\d{6}$", message = "Eircode must start with a letter and followed with 6 digits")
    private String eircode;

}
