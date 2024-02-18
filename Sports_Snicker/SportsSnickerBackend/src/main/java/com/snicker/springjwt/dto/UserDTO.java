package com.snicker.springjwt.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String first_name;

    private String last_name;

    private String email;

}
