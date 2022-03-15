package com.donghyeob.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    /*
    * findByEmail - social login의 return 값 중 email을 통해 이미 생성된 사용자인지
    *   처음 가입하는 사용자인지 판단하기 위한 메소드
    * Optional - Java8 부터 사용되며 NullPointException을 방지할 수 있도록 도와줌
    *   Null이 올 수 있는 값을 감싸주면 됨
    * */
    Optional<User> findByEmail(String email);
}
