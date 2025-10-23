package ecommerce.store.com.service;

import ecommerce.store.com.Mapper.UserMapper;
import ecommerce.store.com.data.model.User;
import ecommerce.store.com.data.repository.UserRepository;
import ecommerce.store.com.dtos.requestDto.UserLoginRequestDto;
import ecommerce.store.com.dtos.requestDto.UserRequest;
import ecommerce.store.com.dtos.responseDto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        if(!userRepository.existsByEmail(userRequest.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = UserMapper.toEntity(dto, passwordEncoder.encode(dto.getPassword()));
        User savedUser = userRepository.save(user);

        return UserMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse loginUser(UserLoginRequestDto userRequest) {
        User user = userRepository.findByEmail(userRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(userRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return UserMapper.toResponse(user);
    }


}
