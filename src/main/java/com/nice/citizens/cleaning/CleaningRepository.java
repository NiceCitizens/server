package com.nice.citizens.cleaning;

import com.nice.citizens.cleaning.Cleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningRepository extends JpaRepository<Cleaning, Long> {

}
