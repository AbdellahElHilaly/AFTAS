package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.dao.model.entity.Member;
import com.youcode.aftas.core.dao.model.fake.DummyMember;
import com.youcode.aftas.core.service.impl.MemberService;
import com.youcode.aftas.shared.Const.AppEndpoints;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AppEndpoints.MEMBER)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemberController {

    private final DummyMember dummyMember;
    private final MemberService memberService;


    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        return ResponseEntity.ok(memberService.getAll());
    }

    @PostMapping
    public ResponseEntity<Member> save() {
        return ResponseEntity.ok(memberService.save(dummyMember.generate()));
    }



}

