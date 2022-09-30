package com.nice.citizens.cleaning_citizen;

import com.nice.citizens.cleaning_citizen.CleaningCitizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningCitizenRepository extends JpaRepository<CleaningCitizen, Long> {

}
