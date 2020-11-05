package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getMemberList(){

        return memberRepository.findAll();
    }

    @Transactional
    public void joinMember(Member member){
        memberRepository.save(member);
    }

}
