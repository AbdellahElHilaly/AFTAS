package com.youcode.aftas.core.dao.repository;

import com.game.play.model.dto.GameInfoDto;
import com.youcode.aftas.core.dao.model.entity.RankId;
import com.youcode.aftas.core.dao.model.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId>, JpaSpecificationExecutor<Ranking> {




}