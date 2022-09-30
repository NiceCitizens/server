package com.nice.citizens.entity;

import com.nice.citizens.jwt.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
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

    public Citizen(String username, String password, List<String> roles, int pointSum, Region region) {
        super(username, password, roles);
        this.pointSum = pointSum;
        this.region = region;
    }

}
