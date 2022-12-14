package com.nice.citizens.jwt;

import com.nice.citizens.citizen.CitizenRepository;
import com.nice.citizens.error.CustomException;
import com.nice.citizens.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final CitizenRepository citizenRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //admin 등 User 상속 엔티티 추가 시 각 엔티티에 맞는 repository로 설정
        return citizenRepository.findByEmail(email)
                .orElseThrow(()->new CustomException(ErrorCode.TOKEN_USER_NOT_FOUND));
    }
}
