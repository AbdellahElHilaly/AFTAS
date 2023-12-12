package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.dao.model.entity.Competition;
import com.youcode.aftas.core.dao.repository.CompetitionRepository;
import com.youcode.aftas.core.service.app_service.CompetitionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    @Override
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Competition getById(UUID uuid) {
        return competitionRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Competition not found with id: " + uuid)
        );
    }

    @Override
    public List<Competition> getAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition update(Competition competition, UUID uuid) {
        competition.setId(getById(uuid).getId());
        return competitionRepository.save(competition);
    }

    @Override
    public void deleteById(UUID uuid) {
        competitionRepository.delete(getById(uuid));
    }

    @Override
    public void deleteAll() {
        competitionRepository.deleteAll();
    }
}
