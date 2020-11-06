package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Page<Member> getMemberList(String country, int size, Pageable pageable) {

        return memberRepository.findAll(country, size, pageable);
    }

    @Transactional
    public void joinMember(Member member) {
        memberRepository.save(member);
    }

}
