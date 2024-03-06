package com.dogether.dogether_back.exception;

// 보통: service에서 if문으로 조건 처리. ex) if !user: return false, else: true
// 그리고 나서, controller에서 값에 따라 프론트에게 return. ex) if true: 찾았습니다. false: 없습니다.
// 그런데, GlobalExceptionHandler 파일을 쓰면, Controller 까지 안가고도 바로 예외를 던지기가 가능해진다.
// ex) service 파일: findById(5).orElseThrow(() => new UserNotFoundException('유저 없음')
// controller 파일: return('유저 첮음') -> controller 파일에서 예외 처리를 안해도 되게 됨!!

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Controller 어노테이션이 쓰인 모든 곳에서 에러를 잡을 수 잇도록 하는 어노테이션
public class GlobalExceptionHandler {

    // EntityNotFoundException은 원래 있는 예외임.
    @ExceptionHandler({EntityNotFoundException.class, UserNotFoundException.class})
    // 꺾쇠 안에 물음표를 넣으면 모든 자료형이 가능해짐
    public ResponseEntity<?> handleEntityNotFoundException(Exception e){ //Exception이, 모든 기타 예외의 상위 개념이므로 이렇개 해주는게 좋음
        // 만액 예외를 명확하게 하고싶을 땐 명확한걸로 적어주는게 좋음
        // ResponseEntity는 HttpStatus를 반환해주기 위해 필요함. 원래 있는 것임
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityExistsException.class, UserDuplicateException.class})
    public ResponseEntity<?> handleFavoriteAlreadyExistException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
