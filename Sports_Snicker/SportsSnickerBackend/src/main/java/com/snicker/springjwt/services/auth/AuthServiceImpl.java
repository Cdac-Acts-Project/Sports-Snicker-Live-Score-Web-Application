package com.snicker.springjwt.services.auth;


import com.snicker.springjwt.dto.SignupDTO;
import com.snicker.springjwt.dto.UserDTO;
import com.snicker.springjwt.entities.User;
import com.snicker.springjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        User user = new User();
        user.setFirst_name(signupDTO.getFirst_name());
        user.setLast_name(signupDTO.getLast_name());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setFirst_name(createdUser.getFirst_name());
        userDTO.setLast_name(createdUser.getLast_name());
        return userDTO;
    }
}
