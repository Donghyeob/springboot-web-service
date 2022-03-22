package com.donghyeob.springboot.service;

import com.donghyeob.springboot.domain.user.UserRepository;
import com.donghyeob.springboot.web.dto.UserSignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSignupRequestDto requestDto) {
        Long id = userRepository.save(requestDto.toEntity()).getId();
        return id;
    }
}
