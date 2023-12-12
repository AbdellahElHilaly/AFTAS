package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.dao.model.dto.MemberDto;
import com.youcode.aftas.core.dao.model.entity.Member;
import com.youcode.aftas.core.service.app_service.MemberService;
import com.youcode.aftas.core.utils.pipe.ResponseFormat;
import com.youcode.aftas.shared.Const.AppEndpoints;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AppEndpoints.MEMBER)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemberController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<Member>> responseFormatList;
    private final ResponseFormat<Member> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;

    @GetMapping
    public ResponseEntity<ResponseFormat<List<Member>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        memberService.getAll(),
                        "Members retrieved successfully"
                ));
    }

    @PostMapping
    public ResponseEntity<ResponseFormat<Member>> save(@Valid  @RequestBody MemberDto memberDto) {
        return ResponseEntity.ok(responseFormat.format(
                memberService.save(modelMapper.map(memberDto, Member.class)),
                "Member saved successfully"
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<Member>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                memberService.getById(id),
                "Member retrieved successfully"
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormat<Member>> update(@Valid  @RequestBody MemberDto memberDto, @PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                memberService.update(modelMapper.map(memberDto, Member.class), id),
                "Member updated successfully"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID id) {
        memberService.deleteById(id);
        return ResponseEntity.ok(responseFormatVoid.format(
                "Member deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        memberService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Members deleted successfully"
        ));
    }

}

