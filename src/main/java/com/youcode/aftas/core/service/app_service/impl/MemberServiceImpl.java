package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.dao.model.entity.Member;
import com.youcode.aftas.core.dao.repository.MemberRepository;
import com.youcode.aftas.core.service.app_service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getById(UUID id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Member not found with id: " + id)
        );
    }

    @Override
    public Member update(Member member, UUID id) {
        member.setId(getById(id).getId());
        return memberRepository.save(member);
    }

    @Override
    public void deleteById(UUID id) {
        memberRepository.delete(getById(id));
    }

    @Override
    public void deleteAll() {
        memberRepository.deleteAll();
    }

}
