package com.dogether.dogether_back.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="users") // ??
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id // 절대 겹칠 일이 없는 column에 이 어노테이션 부여해야한다. findById()는 @id가 붙은 것을 기준으로 find한다.
    @GeneratedValue(strategy = GenerationType.AUTO) //네가 알아서 id를 관리해.
    private Long id; // db 인덱스

    private String name; // 이름
    private String userId; // 아이디
    private String userPw; // 비밀번호

    // FetchType.LAZY는, ex) user를 불러올 때 favoriteList는 나중에 불러들여라는 뜻이다.
    // user의 이름만 필요하다면, favoriteList까지 모두 불러들이는 건 비효율적일 수 있기 때문이다.
    // 그러나 FetchType.LAZY는 이를 우해 쿼리를 2번 날려야 한다 -> N+1 문제가 생길 수 있어서 문제
    // 그러므로, N+1 문제를 감수하더라도 FetchType.LAZY를 써야 할 상황과 그렇지 않은 상황을 판단하는 것이 중요하다

    //CascadeType.ALL은, user가 삭제될 때 favoriteList도 같이 삭제되도록 하라는 뜻이다.
    // 만약 user가 삭제되어도 리뷰는 남기를 바란다면, cascade를 사용하지 않으면 된다.
    // ALL 말고 다른 cascade 종류는 ??
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image profileImg;

    @Builder
    public User(String name, String userId, String userPw) {
        this.name = name;
        this.userId = userId;
        this.userPw = userPw;
    }

}

/*

참고: 다양한 JPA 연관관계 학습하기

  @OneToMany(mappedBy = "user") -> OneToMany 또는 ManyToOne에서 누가 주인인지를 나타내는 것이다.
  // 주인이란, 두 테이블 중 foreign key를 가지고 있는 테이블을 주인이라고 일컫는다.
  // 반대로 생각해보면, ManyToMany 또는 OneToOne에서는 mappedBy를 사용할 필요가 없다.
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Favorite> favoriteList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Subscription> subscriptionList = new ArrayList<>();
 */
