package com.donghyeob.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_function_test() {
        // HelloResponseDto에 대한 단위 테스트
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        // assertThat - 테스트 검증 라이브러리의 검증 메소드
        // isEqualTo - assertj의 동등 비교 메소드
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
