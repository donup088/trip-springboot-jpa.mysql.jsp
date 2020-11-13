package com.trip.tripsoda.repository.notice;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.tripsoda.domain.notice.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.trip.tripsoda.domain.notice.QNotice.notice;

public class NoticeRepositoryImpl  implements NoticeCustomRepository{

    private JPAQueryFactory queryFactory;

    public NoticeRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Notice> findAll(String title, int size, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(notice.id.gt(0));

        QueryResults<Notice> result = queryFactory.selectFrom(notice)
                .orderBy(notice.id.desc())
                .where(builder)
                .offset(pageable.getOffset())
                .limit(size)
                .fetchResults();

        List<Notice> content = result.getResults();
        long total = result.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
