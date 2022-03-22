package com.donghyeob.springboot.web;

import com.donghyeob.springboot.service.UserService;
import com.donghyeob.springboot.web.dto.UserSignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// security filter oauth로 해당 컨트롤러 동작 안함
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    
    @PostMapping("/signup")
    public Long signup(@RequestBody UserSignupRequestDto requestDto) {
        return userService.save(requestDto);
    }
}
