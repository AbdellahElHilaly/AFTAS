package com.youcode.aftas.core.dao.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.youcode.aftas.core.dao.model.entity.Ranking}
 */
@Value
public class RankingDto implements Serializable {
    Integer rank;
    Integer score;
}