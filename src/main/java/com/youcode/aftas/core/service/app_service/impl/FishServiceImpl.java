package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.dao.model.entity.Fish;
import com.youcode.aftas.core.dao.repository.FishRepository;
import com.youcode.aftas.core.service.app_service.FishService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;

    @Override
    public Fish save(Fish fish) {
        return fishRepository.save(fish);
    }

    @Override
    public Fish getById(UUID uuid) {
        return fishRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Fish not found with id: " + uuid)
        );
    }

    @Override
    public List<Fish> getAll() {
        return fishRepository.findAll();
    }

    @Override
    public Fish update(Fish fish, UUID uuid) {
        fish.setId(getById(uuid).getId());
        return fishRepository.save(fish);
    }

    @Override
    public void deleteById(UUID uuid) {
        fishRepository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        fishRepository.deleteAll();
    }
}
