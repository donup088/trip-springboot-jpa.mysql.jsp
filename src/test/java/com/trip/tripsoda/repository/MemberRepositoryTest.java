package com.trip.tripsoda.repository;

import com.trip.tripsoda.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Test
    public void 페이징테스트() {
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.DESC, "id");

        Page<Member> result = memberRepository.findAll(null, 5, pageRequest);

        for (Member member : result) {
            System.out.println("member = " + member);
        }

        assertEquals(result.getSize(),5);
    }

    @Test
    public void 페이징테스트나라별() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "id");

        Page<Member> result = memberRepository.findAll("KOREA", 10, pageRequest);

        for (Member member : result) {
            System.out.println("member = " + member);
        }

        assertEquals(result.getSize(),10);
    }
}