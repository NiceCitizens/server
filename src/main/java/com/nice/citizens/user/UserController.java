package com.nice.citizens.user;

import com.nice.citizens.citizen.Citizen;
import com.nice.citizens.jwt.User;
import com.nice.citizens.user.dto.LoginDto;
import com.nice.citizens.user.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<Citizen>>getAllCitizens(){
        return new ResponseEntity<List<Citizen>>(userService.getAllCitizens(), HttpStatus.OK);
    }
    @PostMapping("citizen_signup")
    public ResponseEntity<User> signup(@RequestBody SignupDto signupDto){
        log.warn("try signup");
        return new ResponseEntity<User>(userService.citizenSignup(signupDto), HttpStatus.OK);
    }
    @PostMapping("citizen_login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<String>(userService.citizenLogin(loginDto), HttpStatus.OK);
    }
    @GetMapping("authorization")
    public ResponseEntity<String> isLogin() {
        return new ResponseEntity<>(userService.isLogin(), HttpStatus.OK);
    }
    @GetMapping("admin")
    public String admin(){
        return SecurityContextHolder.getContext().toString();
    }
}