package com.trip.tripsoda.domain.trip;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class FavoriteTag {
    private boolean sportsTag;

    private boolean photoTag;

    private boolean shoppingTag;

    private boolean eatTag;

    private boolean excitingTag;

    private boolean studyTag;

    private boolean natureTag;
}
