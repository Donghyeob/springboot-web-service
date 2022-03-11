package com.donghyeob.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
//enum - 관련이 있는 상수들의 집합, 상수만으로 작성되어 있으면 반드시 class로 선언할 필요가 없음
public enum Role {

    // Spring security 에서는 권한 코드에 ROLE_ 이 앞에 있어야 함
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
