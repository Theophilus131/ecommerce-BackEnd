package ecommerce.store.com.service;

import ecommerce.store.com.dtos.responseDto.UserResponse;

public interface UserService {
    UserResponse registerUser(UserResponse userRequest);
    UserResponse loginUser(UserResponse userRequest);


}
