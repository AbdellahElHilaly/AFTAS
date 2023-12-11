package com.youcode.aftas.core.service.impl;

import com.youcode.aftas.core.dao.model.entity.Member;
import com.youcode.aftas.core.dao.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor( onConstructor = @__( @Autowired) )
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }
}
