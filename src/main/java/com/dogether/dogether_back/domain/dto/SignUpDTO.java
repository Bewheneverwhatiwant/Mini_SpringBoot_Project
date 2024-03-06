package com.dogether.dogether_back.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    private String userId;
    private String userPw;
    private String Name;

    // @Getter 와 @Setter 어노테이션이 해주는, 눈에 안보이는 과정들
//    public String getUserPw() {
//        return userPw;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public void setUserPw(String userPw) {
//        this.userPw = userPw;
//    }
}
