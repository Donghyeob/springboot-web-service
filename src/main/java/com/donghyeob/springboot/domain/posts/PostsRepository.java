package com.donghyeob.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Posts class로 DB를 접근하게 해줌
// JpaRepository<Entity class, PK Type>를 상속하면 기본적인 CRUD method가 자동으로 생성됨
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
