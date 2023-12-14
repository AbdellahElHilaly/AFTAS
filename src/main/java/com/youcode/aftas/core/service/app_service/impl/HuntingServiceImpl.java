package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.repository.HuntingRepository;
import com.youcode.aftas.core.service.app_service.HuntingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository HuntingRepository;

    @Override
    public Hunting save(Hunting Hunting) {
        return HuntingRepository.save(Hunting);
    }

    @Override
    public Hunting getById(UUID uuid) {
        return HuntingRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Hunting not found with id: " + uuid)
        );
    }

    @Override
    public List<Hunting> getAll() {
        return HuntingRepository.findAll();
    }

    @Override
    public Hunting update(Hunting Hunting, UUID uuid) {
        Hunting.setId(getById(uuid).getId());
        return HuntingRepository.save(Hunting);
    }

    @Override
    public void deleteById(UUID uuid) {
        HuntingRepository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        HuntingRepository.deleteAll();
    }
}
