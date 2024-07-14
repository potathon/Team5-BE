package TEAM5.roomie.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Size(max = 10, message = "Username must be less than 10 characters")
    private String user_name;

    @NotBlank(message = "Phone number is mandatory")
    @Size(max = 20, message = "Phone number must be less than 20 characters")
    private String phone;
}
