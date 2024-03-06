package com.dogether.dogether_back.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//user에 대한 entity

// @AllArgsConstructor: 생성자의 모든 인자를 필요로 한다
// @Builder: 모든 요소를 쉽게 설정 가능, 하지만 개별 접근 불가 -> setter 사용해야한다.
@Getter @Setter
@NoArgsConstructor
public class UserDTO {
    String name;
    String userId;
    String userPw;
}
