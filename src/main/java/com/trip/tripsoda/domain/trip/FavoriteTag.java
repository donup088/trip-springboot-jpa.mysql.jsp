package com.trip.tripsoda.domain.trip;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "trip_favorite_tag")
@ToString(exclude = {"tripDestination"})
public class FavoriteTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    private boolean sports;

    private boolean photo;

    private boolean shopping;

    private boolean eat;

    private boolean exciting;

    private boolean study;

    private boolean nature;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_destination_id")
    private TripDestination tripDestination;
}
