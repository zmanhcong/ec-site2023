package cng.ecsite.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor

public class AdminDto {
    @Size(min = 3, max = 10, message = "Invalid first name! ( 3 - 10 characters)")
    private String firstName;
    @Size(min = 3, max = 10, message = "Invalid first name! ( 3 - 10 characters)")
    private String lastName;
    @Size(min = 3, max = 10, message = "Invalid first name! ( 3 - 10 characters)")
    private String username;
    @Size(min = 3, max = 10, message = "Invalid first name! ( 3 - 10 characters)")
    private String password;
    private String repeatPassword;
}
