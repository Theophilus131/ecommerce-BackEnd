package ecommerce.store.com.Mapper;

import ecommerce.store.com.data.model.Role;
import ecommerce.store.com.data.model.User;
import ecommerce.store.com.dtos.requestDto.UserRequest;
import ecommerce.store.com.dtos.responseDto.UserResponse;

public class UserMapper {


    public static User toEntity(UserRequest dto, String encodedPassword){
        return User.builder()
                .name(dto.getUsername())
                .email(dto.getEmail())
                .password(encodedPassword)
                .role(Role.USER)
                .build();
    }


    public static UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }



}
