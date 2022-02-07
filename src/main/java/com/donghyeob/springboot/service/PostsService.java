package com.donghyeob.springboot.service;

import com.donghyeob.springboot.domain.posts.Posts;
import com.donghyeob.springboot.domain.posts.PostsRepository;
import com.donghyeob.springboot.web.dto.PostsResponseDto;
import com.donghyeob.springboot.web.dto.PostsSaveRequestDto;
import com.donghyeob.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌 @Autowired와 동일한 효과
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        Long id = postsRepository.save(requestDto.toEntity()).getId();
        return id;
    }

    /*update 기능에서 쿼리를 보내는 부분이 없는데 이게 가능한 이유는
    * JPA의 영속성 컨텍스트 때문이다.
    * 영속성 컨텍스트란 엔티티를 영구 저장하는 환경으로 일종의 논리적 개념이라고 보면 되며
    * JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈린다.*/
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
