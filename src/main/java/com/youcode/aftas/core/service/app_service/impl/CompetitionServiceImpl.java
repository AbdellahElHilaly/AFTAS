package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.dao.model.entity.Competition;
import com.youcode.aftas.core.dao.repository.CompetitionRepository;
import com.youcode.aftas.core.service.app_service.CompetitionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    @Override
    public Competition save(Competition competition) {
        log.info("Saving competition: {}", competition);
        return competitionRepository.save(competition);
    }

    @Override
    public Competition getById(UUID uuid) {
        log.info("Fetching competition by ID: {}", uuid);
        return competitionRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Competition not found with id: " + uuid)
        );
    }

    @Override
    public List<Competition> getAll() {
        log.info("Fetching all competitions");
        return competitionRepository.findAll();
    }

    @Override
    public Competition update(Competition competition, UUID uuid) {
        log.info("Updating competition: {}", competition);
        competition.setId(getById(uuid).getId());
        return competitionRepository.save(competition);
    }

    @Override
    public void deleteById(UUID uuid) {
        log.info("Deleting competition by ID: {}", uuid);
        competitionRepository.delete(getById(uuid));
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all competitions");
        competitionRepository.deleteAll();
    }





}
