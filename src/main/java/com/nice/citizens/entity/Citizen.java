package com.nice.citizens.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
//@Builder
@NoArgsConstructor
public class Citizen {
    @Id
    @GeneratedValue
    @Column(name = "CITIZEN_ID")
    private Long Id;

    private String name;

//    enum으로 교체 예정
    private String role;

    private int pointSum = 0;

    @ManyToOne
    private Region region;

    @OneToMany(mappedBy = "citizen")
    private List<CleaningCitizen> cleaningHistory = new ArrayList<>();

//    @OneToMany
//    private List<Citizen> friends = new ArrayList<>();
}
