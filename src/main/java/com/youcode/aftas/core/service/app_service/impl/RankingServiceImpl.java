package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.dao.model.entity.Ranking;
import com.youcode.aftas.core.dao.repository.RankingRepository;
import com.youcode.aftas.core.service.app_service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RankingServiceImpl implements RankingService {

    private final RankingRepository RankingRepository;

    @Override
    public Ranking save(Ranking Ranking) {
        return RankingRepository.save(Ranking);
    }

    @Override
    public Ranking getById(UUID uuid) {
        return RankingRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Ranking not found with id: " + uuid)
        );
    }

    @Override
    public List<Ranking> getAll() {
        return RankingRepository.findAll();
    }

    @Override
    public Ranking update(Ranking Ranking, UUID uuid) {
        Ranking.setId(getById(uuid).getId());
        return RankingRepository.save(Ranking);
    }

    @Override
    public void deleteById(UUID uuid) {
        RankingRepository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        RankingRepository.deleteAll();
    }
}
