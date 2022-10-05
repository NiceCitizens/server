package com.nice.citizens.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    NOT_EXIST_EMAIL(BAD_REQUEST,"이메일 중복"),
    NOT_CORRECT_PASSWORD(BAD_REQUEST,"잘못된 패스워드"),

    TOKEN_USER_NOT_FOUND(BAD_REQUEST, "존재하지 않는 유저"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
