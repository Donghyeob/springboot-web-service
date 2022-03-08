package com.donghyeob.springboot.web;

import com.donghyeob.springboot.config.auth.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/*
    spring boot 기본 junit5 @RunWith 대신 ExtendWith를 사용하며
    @SpringBootTest를 사용하면 생략가능
 */
@ExtendWith(SpringExtension.class)
/*@WebMvcTest(HelloController.class) // @Controller, @ControllerAdvice 등을 사용할 수 있음 HelloController에 대한 단위 테스트*/
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = SecurityConfig.class)
        })
public class HelloControllerTest {

    /*스프링이 관리하는 Bean을 주입
    * MockMvc는 웹 API를 테스트할 때 사용됨
    * 스프링 MVC테스트의 시작점*/
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(roles = "USER")
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void helloDto_return() throws Exception {
        String name = "hello";
        int amount = 1000;

        // .param - string 값만 허용
        // jsonPath - JSON 응답값을 필드별로 검증할 수 있는 메소드
        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
                // perform() 메소드를 이용하여 요청을 전송하면
                // 그 결과로 ResultActions 객체를 리턴하는데 이 객체는 응답 결과를 검증할 수 있는 andExpect() 메소드를 제공한다
                // andDo() 메서드로 요청과 응답 메시지를 모두 확인할 수 있음
    }
}
