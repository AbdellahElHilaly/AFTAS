package com.youcode.aftas.core.database.repository;

import com.youcode.aftas.core.database.model.include.RankId;
import com.youcode.aftas.core.database.model.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId>, JpaSpecificationExecutor<Ranking> {




}