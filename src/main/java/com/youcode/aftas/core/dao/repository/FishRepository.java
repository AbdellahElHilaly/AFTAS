package com.youcode.aftas.core.dao.repository;

import com.youcode.aftas.core.dao.model.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface FishRepository extends JpaRepository<Fish, UUID>, JpaSpecificationExecutor<Fish> {
    public Fish findByName(String name);
}