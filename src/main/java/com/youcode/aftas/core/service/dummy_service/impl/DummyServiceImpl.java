package com.youcode.aftas.core.service.dummy_service.impl;

import com.youcode.aftas.core.dao.model.entity.Hunting;
import com.youcode.aftas.core.dao.model.fake.*;
import com.youcode.aftas.core.dao.repository.*;
import com.youcode.aftas.core.service.dummy_service.DummyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DummyServiceImpl implements DummyService {

    private final MemberRepository memberRepository;
    private final CompetitionRepository competitionRepository;
    private final FishRepository fishRepository;
    private final HuntingRepository huntingRepository;
    private final LevelRepository levelRepository;


    private final DummyCompetition dummyCompetition;
    private final DummyMember dummyMember;
    private final DummyFish dummyFish;
    private final DummyHunting dummyHunting;
    private final DummyLevel dummyLevel;

    @Override
    public void save() {
        memberRepository.save(dummyMember.generate());
        competitionRepository.save(dummyCompetition.generate());
        fishRepository.save(dummyFish.generate());
        huntingRepository.save(dummyHunting.generate());
        levelRepository.save(dummyLevel.generate());
    }

    @Override
    public void saveCollection(int size) {
        clear();
        memberRepository.saveAll(dummyMember.generateCollection(size));
        fishRepository.saveAll(dummyFish.generateCollection(size));
        competitionRepository.saveAll(dummyCompetition.generateCollection(size));
        huntingRepository.saveAll(dummyHunting.generateCollection(size));
        levelRepository.saveAll(dummyLevel.generateCollection(size));
    }

    @Override
    public void clear() {
        memberRepository.deleteAll();
        competitionRepository.deleteAll();
        fishRepository.deleteAll();
        huntingRepository.deleteAll();
        levelRepository.deleteAll();
    }


}














