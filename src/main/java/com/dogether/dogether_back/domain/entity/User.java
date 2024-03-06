package com.dogether.dogether_back.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="users") // ??
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id // 절대 겹칠 일이 없는 column에 이 어노테이션 부여해야한다.
    @GeneratedValue(strategy = GenerationType.AUTO) //네가 알아서 id를 관리해.
    private Long id; // db 인덱스

    private String name; // 이름
    private String userId; // 아이디
    private String userPw; // 비밀번호

    // ??
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image profileImg;

    // ??
    @Builder
    public User(String name, String userId, String userPw) {
        this.name = name;
        this.userId = userId;
        this.userPw = userPw;
    }

}
