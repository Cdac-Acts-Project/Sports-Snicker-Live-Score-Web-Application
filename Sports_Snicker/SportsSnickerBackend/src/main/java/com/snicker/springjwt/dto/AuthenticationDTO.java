package com.snicker.springjwt.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String email;

    private String password;

}
