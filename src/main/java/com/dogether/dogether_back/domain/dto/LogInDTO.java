package com.dogether.dogether_back.domain.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder //Builder 어노테이션을 사용하려면 반드시 AllArgs... 어노테이션이 같이 있어야 한다
public class LogInDTO {

    private String userId;
    private String userPw;
    private Long id; // DB에서 인덱스로 관리되는 id이다.
}
