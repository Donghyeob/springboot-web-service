package com.donghyeob.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Posts class로 DB를 접근하게 해줌
// JpaRepository<Entity class, PK Type>를 상속하면 기본적인 CRUD method가 자동으로 생성됨
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
