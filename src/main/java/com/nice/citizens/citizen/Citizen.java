package com.nice.citizens.citizen;

import com.nice.citizens.cleaning_citizen.CleaningCitizen;
import com.nice.citizens.jwt.User;
import com.nice.citizens.region.Region;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Citizen extends User {
    @Id
    @GeneratedValue
    @Column(name = "CITIZEN_ID")
    private Long Id;

    private int pointSum = 0;

    @ManyToOne
    private Region region;

    @OneToMany(mappedBy = "citizen")
    private List<CleaningCitizen> cleaningHistory = new ArrayList<>();

//    @OneToMany
//    private List<Citizen> friends = new ArrayList<>();

    @Builder
    public Citizen(String email, String username, String password, String role, Region region) {
        super(email, username, password, role);
        this.region = region;
    }

}
