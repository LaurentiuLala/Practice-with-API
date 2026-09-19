package com.example.testofskills.Models;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "place")
@Entity(name = "Place")
@Builder
public class Place {

    @Id
    @SequenceGenerator(
name ="Place sequence",
sequenceName = "place_sequence",
allocationSize =1
    )
@GeneratedValue(
strategy = SEQUENCE,
generator ="place_sequence"
)

    @Column(name = "id")
private long id;

    @Column(name = "name",
    nullable = false
    )
private String name;

    @Column(name = "address",
            nullable = false
    )
    private String address;

    @Column(name = "city",
            nullable = false
    )
    private String city;

    @Column(name = "tags")
    private Tags tags;

    @Column(name = "rating")
    private int rating;
}
