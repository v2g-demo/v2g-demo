package com.v2gdemo.backend.dto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String name;
    private String password;
    private String email;
}
