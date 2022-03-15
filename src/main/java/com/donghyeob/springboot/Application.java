package com.donghyeob.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Project main class - Application
//@EnableJpaAuditing // JPA auditing 활성화(BaseTimeEntity) JpaConfig로 이동
@SpringBootApplication // 스프링 부트 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
public class Application {
    public static void main(String[] args) {
        // run - 내장 WAS를 실행하며 외부에 WAS를 두지 않고 실행할 때 마다 내부에서 WAS를 실행하게 됨
        SpringApplication.run(Application.class, args);
    }
}
