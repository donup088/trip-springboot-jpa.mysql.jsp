package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.repository.member.MemberRepository;
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

    public Page<Member> getMemberList(String country, int size, String userid, Pageable pageable) {

        return memberRepository.findAll(country, size, userid, pageable);
    }

    @Transactional
    public void joinMember(Member member) {
        memberRepository.save(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public Member findMemberToBuyTour(String name) {
        Member findMember = memberRepository.findByName(name);
        int tourCount = findMember.getTourCount();
        findMember.setTourCount(tourCount+1);

        return findMember;
    }
}
