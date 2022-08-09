package com.nice.citizens.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
//@Builder
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue
    @Column(name="REGION_ID")
    private Long Id;

    private int pointSumRegion = 0;

}
