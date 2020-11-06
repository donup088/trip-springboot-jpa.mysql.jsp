package com.trip.tripsoda.repository.admin;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.tripsoda.domain.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.trip.tripsoda.domain.QAdmin.*;

public class AdminRepositoryImpl implements AdminCustomRepository{
    private JPAQueryFactory queryFactory;

    public AdminRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Admin> findAll(String country, int count, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(admin.id.gt(0));

        if (country != null&& !country.equals("")) {
            builder.and(admin.country.eq(country));
        }


        QueryResults<Admin> result = queryFactory.selectFrom(admin)
                .orderBy(admin.id.desc())
                .where(builder)
                .offset(pageable.getOffset())
                .limit(count)
                .fetchResults();

        List<Admin> content = result.getResults();
        long total = result.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
