package com.trip.tripsoda.repository;

import com.trip.tripsoda.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
@Transactional
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 더미데이터생성() {
        for (int i = 0; i < 20; i++) {
            Member member = new Member();
            member.setUserid("user" + i);
            member.setName("일반회원" + i);
            member.setPhone("123-123-" + i);
            member.setEmail("user" + i + "@test.com");
            member.setCountry("KOREA");
            memberRepository.save(member);
        }

        for (int i = 20; i < 40; i++) {
            Member member = new Member();
            member.setUserid("user" + i);
            member.setName("일반회원" + i);
            member.setPhone("123-123-" + i);
            member.setEmail("user" + i + "@test.com");
            member.setCountry("JAPAN");
            memberRepository.save(member);
        }

        for (int i = 40; i < 60; i++) {
            Member member = new Member();
            member.setUserid("user" + i);
            member.setName("일반회원" + i);
            member.setPhone("123-123-" + i);
            member.setEmail("user" + i + "@test.com");
            member.setCountry("CHINA");
            memberRepository.save(member);
        }

    }
}