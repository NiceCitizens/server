package com.nice.citizens.repository;

import com.nice.citizens.entity.Cleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningRepository extends JpaRepository<Cleaning, Long> {

}
