package com.trip.tripsoda.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.tripsoda.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import java.util.List;

import static com.trip.tripsoda.domain.QMember.*;

public class MemberRepositoryImpl implements MemberCustomRepository {

    private JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Member> findAll(String country, int count, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(member.id.gt(0));

        if (country != null&& !country.equals("")) {
            builder.and(member.country.eq(country));
        }


        QueryResults<Member> result = queryFactory.selectFrom(member)
                .orderBy(member.id.desc())
                .where(builder)
                .offset(pageable.getOffset())
                .limit(count)
                .fetchResults();

        List<Member> content = result.getResults();
        long total = result.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
