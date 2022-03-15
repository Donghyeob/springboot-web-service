package com.donghyeob.springboot.domain.user;

import com.donghyeob.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Column
    private String mobile;

    /*JPA를 통해 db로 저장할 때 Enum 값을 어떤 형태로 저장 할지를 결정한다. default:int
    숫자로 저장되면 db로 확인할 때 그 값이 무슨 코드를 의미하는지 알 수 없기 때문에
        문자열(EnumType.STRING)로 저장될 수 있도록 선언
    */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, String mobile, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.mobile = mobile;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
