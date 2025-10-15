package ecommerce.store.com.dtos.responseDto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String role;

}
