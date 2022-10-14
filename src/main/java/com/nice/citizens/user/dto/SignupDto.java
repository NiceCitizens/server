package com.nice.citizens.user.dto;

import com.nice.citizens.citizen.Citizen;
import com.nice.citizens.region.Region;
import com.nice.citizens.region.RegionName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupDto {
    private String email;
    private String username;
    private String password;
    private RegionName regionName;

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
