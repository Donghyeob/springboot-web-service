package com.donghyeob.springboot.web;

import com.donghyeob.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    @RestController는 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
    @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 됨
*/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        // @RequestParam("name") 외부에서 "name"이라는 이름으로 넘긴 파라미터를 저장하게 됨
        return new HelloResponseDto(name, amount);
    }
}
