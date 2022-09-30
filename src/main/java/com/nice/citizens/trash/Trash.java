package com.nice.citizens.trash;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table
@Getter
//@Builder
@NoArgsConstructor
public class Trash {
    @Id
    @GeneratedValue
    @Column(name="TRASH_ID")
    private Long Id;

    private Point location;
}
