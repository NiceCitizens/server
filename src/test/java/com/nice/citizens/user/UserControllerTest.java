package com.nice.citizens.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice.citizens.citizen.Citizen;
import com.nice.citizens.citizen.CitizenRepository;
import com.nice.citizens.region.RegionName;
import com.nice.citizens.user.dto.LoginDto;
import com.nice.citizens.user.dto.SignupDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired CitizenRepository citizenRepository;
    @Autowired PasswordEncoder passwordEncoder;
    ResultActions trySignup(String email, String username, String password) throws Exception{
        SignupDto signupDto = new SignupDto(email,username,password,RegionName.SEOUL);
        String content = objectMapper.writeValueAsString(signupDto);
        return mockMvc.perform(post("/user/citizen_signup")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("회원 가입")
    void signUpSubmit() throws Exception {
        trySignup("email@email.com","username","password")
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
        Citizen citizen = citizenRepository.findByEmail("email@email.com").orElse(new Citizen());
        assertNotEquals(citizen.getPassword(), passwordEncoder.encode("password"));
    }
    @Test
    @DisplayName("로그인")
    void login() throws Exception{
        trySignup("email@email.com", "username", "password")
                .andExpect(status().is2xxSuccessful());
        LoginDto loginDto = new LoginDto("email@email.com","password");
        String content = objectMapper.writeValueAsString(loginDto);
        mockMvc.perform(post("/user/citizen_login")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}