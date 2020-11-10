package com.trip.tripsoda.repository.tour;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.tripsoda.domain.dirver.Driver;
import com.trip.tripsoda.domain.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.trip.tripsoda.domain.tour.QTour.tour;

public class TourRepositoryImpl implements TourCustomRepository{
    private JPAQueryFactory queryFactory;

    public TourRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Tour> findAll(String country, String region, String city, Driver driver, LocalDateTime tourDate, int count, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(tour.id.gt(0));

        if (country != null && !country.equals("")) {
            builder.and(tour.address.country.eq(country));
        }

        if (city != null && !city.equals("")) {
            builder.and(tour.address.city.eq(city));
        }

        if (region != null && !region.equals("")) {
            builder.and(tour.address.region.eq(region));
        }


        if (driver != null && !driver.equals("")) {
            builder.and(tour.driver.name.eq(driver.getName()));
        }

        if (tourDate != null && !tourDate.equals("")) {
            builder.and(tour.tourDate.eq(tourDate));
        }



        QueryResults<Tour> result = queryFactory.selectFrom(tour)
                .orderBy(tour.id.desc())
                .where(builder)
                .offset(pageable.getOffset())
                .limit(count)
                .fetchResults();

        List<Tour> content = result.getResults();
        long total = result.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
