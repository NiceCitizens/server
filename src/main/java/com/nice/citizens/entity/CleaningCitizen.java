package com.nice.citizens.entity;

import javax.persistence.*;

@Entity
@Table
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
