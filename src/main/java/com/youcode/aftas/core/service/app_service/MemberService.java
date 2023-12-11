package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.dao.model.entity.Member;

import java.util.List;
import java.util.UUID;

public interface MemberService {
    public Member save(Member member);

    List<Member> getAll();

    Member getById(UUID id);
    Member update(Member member, UUID id);
    void deleteById(UUID id);
    void deleteAll();
}
