package com.trip.tripsoda.repository;

import com.trip.tripsoda.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long>, MemberCustomRepository {

}
