package com.nice.citizens.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
//@Builder
@NoArgsConstructor
public class Cleaning {
    @Id
    @GeneratedValue
    private Long Id;

//    리워드
    private int point;

//    작업 일시
    private Date startTime;

    private Date endTime;

//    정확한 작업 위치
    private Point location;

//    이미지 http 주소
    private String beforeImg;
    private String afterImg;

//    모집인원
    private int intake;

//    작업 등록자
    @OneToOne
    private Citizen register_citizen;

//    작업 참석자
    @OneToMany(mappedBy = "cleaning")
    private List<CleaningCitizen> attemptCitizens = new ArrayList<>();

}
