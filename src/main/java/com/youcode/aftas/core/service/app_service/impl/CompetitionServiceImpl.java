package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.dao.model.entity.Competition;
import com.youcode.aftas.core.dao.repository.CompetitionRepository;
import com.youcode.aftas.core.service.app_service.CompetitionService;
import com.youcode.aftas.core.utils.pipe.vm.CompetitionVm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final ModelMapper modelMapper;


    @Override
    public CompetitionVm save(Competition competition) {
        return modelMapper.map(
                competitionRepository.save(competition), CompetitionVm.class
        );
    }

    @Override
    public CompetitionVm findById(UUID uuid) {
        return modelMapper.map(
                competitionRepository.findById(uuid).orElseThrow(NoSuchElementException::new), CompetitionVm.class
        );
    }

    @Override
    public List<CompetitionVm> getAll() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(competition -> modelMapper.map(competition, CompetitionVm.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompetitionVm update(Competition competition, UUID uuid) {
        competition.setId(findById(uuid).getId());
        return modelMapper.map(
                competitionRepository.save(competition), CompetitionVm.class
        );
    }

    @Override
    public void deleteById(UUID uuid) {
        competitionRepository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        competitionRepository.deleteAll();
    }
}
