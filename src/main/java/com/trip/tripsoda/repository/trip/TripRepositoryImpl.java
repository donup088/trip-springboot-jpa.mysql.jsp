package com.trip.tripsoda.repository.trip;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.tripsoda.domain.trip.TripDestination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.trip.tripsoda.domain.trip.QTripDestination.*;


public class TripRepositoryImpl implements TripCustomRepository {
    private JPAQueryFactory queryFactory;

    public TripRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<TripDestination> findAll(String country, String region, String city, int count, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(tripDestination.id.gt(0));

        if (country != null && !country.equals("")) {
            builder.and(tripDestination.country.eq(country));
        }

        if (city != null && !city.equals("")) {
            builder.and(tripDestination.city.eq(city));
        }

        if (region != null && !region.equals("")) {
            builder.and(tripDestination.region.eq(region));
        }

        QueryResults<TripDestination> result = queryFactory.selectFrom(tripDestination)
                .orderBy(tripDestination.id.desc())
                .where(builder)
                .offset(pageable.getOffset())
                .limit(count)
                .fetchResults();

        List<TripDestination> content = result.getResults();
        long total = result.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}

