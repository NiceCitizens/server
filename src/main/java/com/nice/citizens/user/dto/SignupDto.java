package com.nice.citizens.user.dto;

import com.nice.citizens.citizen.Citizen;
import com.nice.citizens.region.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
    private String email;
    private String username;
    private String password;
    private String regionName;

    public Citizen toEntity(Region region) {
        return Citizen.builder()
                .email(email)
                .username(username)
                .password(password)
                .role("CITIZEN")
                .region(region)
                .build();
    }
}
