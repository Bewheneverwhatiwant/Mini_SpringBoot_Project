package com.dogether.dogether_back.service;

import com.dogether.dogether_back.domain.dto.ImageDTO;
import com.dogether.dogether_back.domain.dto.InfoDTO;
import com.dogether.dogether_back.domain.dto.SignUpDTO;
import com.dogether.dogether_back.domain.dto.LogInDTO;
import com.dogether.dogether_back.domain.entity.Image;
import com.dogether.dogether_back.domain.entity.User;
import com.dogether.dogether_back.exception.UserDuplicateException;
import com.dogether.dogether_back.exception.UserNotFoundException;
import com.dogether.dogether_back.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // UserService에서 회원가입 로직이다.
    public String createUser(SignUpDTO signupDto){

        // findByUserId 함수는 별도로 정의해야 한다.
        // 만약 회원가입하려는 아이디가 이미 있으면
        if(userRepository.findByUserId(signupDto.getUserId()).isPresent()){
            // 예외도 별도 정의
            throw new UserDuplicateException("아이디가 이미 존재합니다.");
        }
        // isPresent()를 사용하려면, UserRepository에서 user가 optional 타입이어야 한다.
        // 웬만하면 optional을 달아주자.

        // 아이디가 중복되지 않으면, User 객체 생성
        User user = User.builder()
                .userId(signupDto.getUserId())
                .userPw(signupDto.getUserPw())
                .name(signupDto.getName())
                .build();

        userRepository.save(user); // DB에 User 객체 저장 -> 회원가입 완료

        return signupDto.getUserId();
    }

    // UserService에서 로그인을 하는 로직
    public LogInDTO checkUser(LogInDTO loginDto){
        // DB에서 userId로 유저를 찾아서 user 객체에 바로 담아라.
        User user = userRepository.findByUserId(loginDto.getUserId())
                // 아니면 예외를 던져라.
                .orElseThrow(()-> new UserNotFoundException("ID가 존재하지 않습니다."));

        // 비밀번호가 똑같아서 로그인에 성공하면 DTO를 빌드하라.
        if(loginDto.getUserPw().equals(user.getUserPw())){
            return LogInDTO.builder()
                    .id(user.getId())
                    .userId(user.getUserId())
                    .build();
        }
        // 아니면 예외를 던져라
        else{
            throw new UserNotFoundException("비밀번호가 올바르지 않습니다.");
        }
    }

    // 프로필 이미지 바꾸기 로직

//    public InfoDTO changeProfileImageById(ImageDTO dto) {
//        User user = userRepository.findByUserId(dto.getUserId())
//                .orElseThrow(() -> new UserNotFoundException(dto.getUserId()));
//
//        Image image = user.getProfileImg() != null ? user.getProfileImg() : new Image();
//        try {
//            image.setData(dto.getImage().getBytes());
//        } catch (IOException e) {
//            image.setData(null);
//        }
//        user.setProfileImg(image);
//        userRepository.save(user);
//
//        InfoDTO.InfoDTOBuilder builder = InfoDTO.builder()
//                .id(user.getId())
//                .userId(user.getUserId())
//                .name(user.getName());
//        if (user.getProfileImg() != null) {
//            builder.profileImage(user.getProfileImg().getData());
//        }
//        return builder.build();
//    }


}
