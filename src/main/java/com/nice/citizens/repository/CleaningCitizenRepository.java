package com.nice.citizens.repository;

import com.nice.citizens.entity.CleaningCitizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningCitizenRepository extends JpaRepository<CleaningCitizen, Long> {

}
