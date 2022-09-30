package com.nice.citizens.user;

import com.nice.citizens.citizen.Citizen;
import com.nice.citizens.region.Region;
import com.nice.citizens.region.RegionRepository;
import com.nice.citizens.citizen.CitizenRepository;
import com.nice.citizens.user.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final CitizenRepository citizenRepository;
    private final RegionRepository regionRepository;

    public Citizen citizenSignup(@RequestBody SignupDto signupDto){
        Region region = regionRepository.findByRegionName(signupDto.getRegionName()).orElseThrow(()->new RuntimeException());
        Citizen citizen = signupDto.toEntity(region);
        return citizenRepository.save(citizen);
    }

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }
}
