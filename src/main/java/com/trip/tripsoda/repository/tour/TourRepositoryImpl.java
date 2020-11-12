package com.trip.tripsoda.repository.tour;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.tripsoda.domain.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.trip.tripsoda.domain.tour.QTour.tour;

public class TourRepositoryImpl implements TourCustomRepository {
    private JPAQueryFactory queryFactory;

    public TourRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Tour> findAll(String country, String region, String city, String driverName, String tourDate, int count, String tourType, Pageable pageable) {
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

        if (driverName != null && !driverName.equals("")) {
            builder.and(tour.driver.name.eq(driverName));
        }

        if (tourType != null && !tourType.equals("")) {
            builder.and(tour.tourType.eq(tourType));
        }

        if (tourDate != null && !tourDate.equals("")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateTime = LocalDate.parse(tourDate, formatter);
            LocalDate nextDay = dateTime.plusDays(1);
            builder.and(tour.tourDate.between(dateTime,nextDay));
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
