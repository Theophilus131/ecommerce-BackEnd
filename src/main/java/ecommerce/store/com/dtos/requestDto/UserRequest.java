package ecommerce.store.com.dtos.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserRequest {

    @Size(min = 3, max = 20)
    private String username;

    @Email
    private String email;
    @NotBlank @Size(min = 6, max = 40)
    private String password;
    private String role;
}
