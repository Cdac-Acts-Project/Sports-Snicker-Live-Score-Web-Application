package com.snicker.springjwt.services.auth;


import com.snicker.springjwt.dto.SignupDTO;
import com.snicker.springjwt.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
