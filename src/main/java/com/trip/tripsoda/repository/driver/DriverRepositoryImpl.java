package com.trip.tripsoda.repository.driver;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.tripsoda.domain.dirver.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.trip.tripsoda.domain.dirver.QDriver.*;


public class DriverRepositoryImpl implements DriverCustomRepository{
    private JPAQueryFactory queryFactory;

    public DriverRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Driver> findAll(String country, int count, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(driver.id.gt(0));

        if (country != null&& !country.equals("")) {
            builder.and(driver.country.eq(country));
        }


        QueryResults<Driver> result = queryFactory.selectFrom(driver)
                .orderBy(driver.id.desc())
                .where(builder)
                .offset(pageable.getOffset())
                .limit(count)
                .fetchResults();

        List<Driver> content = result.getResults();
        long total = result.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
