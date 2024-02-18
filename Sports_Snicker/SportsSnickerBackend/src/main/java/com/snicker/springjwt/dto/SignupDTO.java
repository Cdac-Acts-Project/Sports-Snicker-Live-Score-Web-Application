package com.snicker.springjwt.dto;

import lombok.Data;

@Data
public class SignupDTO {

    private String first_name;

    private String last_name;

    private String email;

    private String password;

}
