package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.database.model.include.RankId;
import com.youcode.aftas.core.database.model.entity.Ranking;
import com.youcode.aftas.core.database.repository.RankingRepository;
import com.youcode.aftas.core.service.app_service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RankingServiceImpl implements RankingService {

    private final RankingRepository RankingRepository;

    @Override
    public Ranking save(Ranking Ranking) {
        return RankingRepository.save(Ranking);
    }

    @Override
    public Ranking getById(RankId rankId) {
        return RankingRepository.findById(rankId).orElseThrow(
                () -> new NoSuchElementException("Ranking not found with id: " + rankId)
        );
    }

    @Override
    public List<Ranking> getAll() {
        return RankingRepository.findAll();
    }

    @Override
    public Ranking update(Ranking Ranking, RankId rankId) {
        Ranking.setId(getById(rankId).getId());
        return RankingRepository.save(Ranking);
    }

    @Override
    public void deleteById(RankId rankId) {
        RankingRepository.deleteById(rankId);
    }

    @Override
    public void deleteAll() {
        RankingRepository.deleteAll();
    }

    @Override
    public void findByCompetitionAndMemberOrThrow(Competition competition, Member member) {
        RankingRepository.findByCompetitionAndMember(competition, member).orElseThrow(
                () -> new NoSuchElementException("Ranking not found with competition: " + competition + " and member: " + member)
        );
    }
}
