package com.donghyeob.springboot.web.dto;

import com.donghyeob.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
* Controller와 Service에서 사용되며 Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성
*   Entity 클래스를 Request/Response 클래스로 사용하면 안됨
*   Entity 클래스를 변경하는 것은 너무 큰 변경이므로 Controller에서 사용할 Dto를 분리 해줘야함
*   Entity class - db와 맞닿아 있음, data 출력의 자유가 떨어질 수 있음
*   Dto - View를 위한 class
* */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    // 필수 값을 위한 builder 패턴
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 위에 포함된 필드만 builder에 포함 
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
