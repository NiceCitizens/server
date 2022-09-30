package com.nice.citizens.cleaning_citizen;

import com.nice.citizens.citizen.Citizen;
import com.nice.citizens.cleaning.Cleaning;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
public class CleaningCitizen {
    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name="CITIZEN_ID")
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name="CLEANING_ID")
    private Cleaning cleaning;

}
