package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.dao.model.entity.Level;
import com.youcode.aftas.core.dao.repository.LevelRepository;
import com.youcode.aftas.core.service.app_service.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LevelServiceImpl implements LevelService {

    private final LevelRepository LevelRepository;

    @Override
    public Level save(Level Level) {
        return LevelRepository.save(Level);
    }

    @Override
    public Level getById(UUID uuid) {
        return LevelRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Level not found with id: " + uuid)
        );
    }

    @Override
    public List<Level> getAll() {
        return LevelRepository.findAll();
    }

    @Override
    public Level update(Level Level, UUID uuid) {
        Level.setId(getById(uuid).getId());
        return LevelRepository.save(Level);
    }

    @Override
    public void deleteById(UUID uuid) {
        LevelRepository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        LevelRepository.deleteAll();
    }
}
