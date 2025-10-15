package ecommerce.store.com.service;

import ecommerce.store.com.data.repository.UserRepository;
import ecommerce.store.com.dtos.responseDto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();



    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse registerUser(UserResponse userRequest) {

       return null;
    }

    @Override
    public UserResponse loginUser(UserResponse userRequest) {
        return null;
    }


}
