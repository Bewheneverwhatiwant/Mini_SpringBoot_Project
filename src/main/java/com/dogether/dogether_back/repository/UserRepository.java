package com.dogether.dogether_back.repository;

import com.dogether.dogether_back.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // findById -> @id 어노테이션이 달린 변수를 기준으로 찾음
    // 이오에 find어쩌구By저쩌구... 함수를 커스텀해서 만들고 싶다면? 아래처럼 작성하면 끝!
    Optional<User> findByUserId(String userId);
    Optional<User> findByUserPw(String userPw);

    // user가 잇을 수도 있고 없을 수도 있는데 user를 반환하라고 하는 경우, 오류가 날 수도 있으므로
    // 여기서 optional 설정을 안해주면 UserService에서 isPresent()가 오류나게 된다.
    // optional을 통해 유저가 있을수도, 없을수도 있다고 해줘야 isPresent()함수가 작동한다.
}
