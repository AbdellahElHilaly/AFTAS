package com.youcode.aftas.core.service.impl;

import com.youcode.aftas.core.dao.model.entity.Member;

import java.util.List;

public interface MemberService {
    public Member save(Member member);

    List<Member> getAll();
}
