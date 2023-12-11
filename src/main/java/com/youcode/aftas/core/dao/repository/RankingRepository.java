package com.youcode.aftas.core.dao.repository;

import com.youcode.aftas.core.dao.model.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RankingRepository extends JpaRepository<Ranking, UUID>, JpaSpecificationExecutor<Ranking> {
}