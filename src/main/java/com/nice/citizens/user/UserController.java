package com.nice.citizens.user;

import com.nice.citizens.citizen.Citizen;
import com.nice.citizens.jwt.JwtTokenProvider;
import com.nice.citizens.jwt.User;
import com.nice.citizens.user.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<Citizen>>getAllCitizens(){
        return new ResponseEntity<List<Citizen>>(userService.getAllCitizens(), HttpStatus.OK);
    }
    @PostMapping("signup")
    public ResponseEntity<User> signup(@RequestBody SignupDto signupDto){
        return new ResponseEntity<User>(userService.citizenSignup(signupDto), HttpStatus.OK);
    }
}
