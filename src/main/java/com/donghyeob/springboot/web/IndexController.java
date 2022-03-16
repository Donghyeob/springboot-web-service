package com.donghyeob.springboot.web;

import com.donghyeob.springboot.config.auth.LoginUser;
import com.donghyeob.springboot.config.auth.dto.SessionUser;
import com.donghyeob.springboot.service.PostsService;
import com.donghyeob.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    /*
     * @LoginUser SessionUser user - 기본에 httpSession.getAttribute("user")로 가져오던 세션 정보 값을 개선.
     *      어느 컨트롤러든지 @LoginUser 어노테이션을 사용하면 세션 정보를 가져올 수 있음.
     */
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        // Model - 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        // src/main/resources/templates/index.mustache로 변환되어 View Resolver가 처리하게 됨
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
