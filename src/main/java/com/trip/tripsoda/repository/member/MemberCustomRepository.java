package com.trip.tripsoda.repository.member;


import com.trip.tripsoda.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberCustomRepository {
    Page<Member> findAll(String country, int count, Pageable pageable);
}
