package com.nice.citizens.region;

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
    @Enumerated(EnumType.STRING)
    private RegionName regionName;
    private int pointSumRegion = 0;

}
