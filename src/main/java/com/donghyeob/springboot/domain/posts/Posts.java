package com.donghyeob.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
    Entity method에선 Setter를 따로 만들지 않는데, 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지
    코드상으로 명확하게 구분할 수가 없어서 차후 기능 변경 시 복잡해지기 때문
    필요하다면 method를 따로 추가
*/
@Getter
@NoArgsConstructor
@Entity // Table과 링크될 클래스임을 나타내며 tblColunmName -> tbl_column_name으로 매칭함
public class Posts {
// Posts class는 실제 DB의 테이블과 매칭될 클래스, Entity Class라고 함

    @Id // table pk key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성 규칙, GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 적용됨
    private Long id;

    @Column(length = 500, nullable = false) // 선언하지 않아도 해당 class 내의 필드는 모두 컬럼이 되지만 변경이 필요한 옵션이 있을 때 사용
    private String title; // String의 경우 VARCHAR(255)가 기본

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
