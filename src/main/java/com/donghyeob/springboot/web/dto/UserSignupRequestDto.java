package com.donghyeob.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignupRequestDto {
    private String name;
    private String email;
    private String password;
    private String role;
}
