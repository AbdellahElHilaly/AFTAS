package com.youcode.aftas.core.service.dummy_service.impl;

import com.youcode.aftas.core.dao.model.entity.Member;
import com.youcode.aftas.core.dao.model.fake.DummyMember;
import com.youcode.aftas.core.dao.repository.MemberRepository;
import com.youcode.aftas.core.service.dummy_service.DummyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DummyServiceImpl implements DummyService<Member> {
    private final MemberRepository memberRepository;
    private final DummyMember dummyMember;
    @Override
    public Member save() {
        return memberRepository.save(dummyMember.generate());
    }

    @Override
    public List<Member> saveCollection(int size) {
        return memberRepository.saveAll(dummyMember.generateCollection(size));
    }
}














