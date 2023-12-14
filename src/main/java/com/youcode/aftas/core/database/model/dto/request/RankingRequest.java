package com.youcode.aftas.core.database.model.dto.request;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.database.model.entity.Ranking;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Ranking}
 */
@Value
public class RankingRequest implements Serializable {
    @NotNull(message = "Rank is required")
    @PositiveOrZero(message = "Rank should be positive or zero")
    Integer rank;

    @NotNull(message = "Rank is required")
    @PositiveOrZero(message = "Rank should be positive or zero")
    Integer score;

    @NotNull(message = "Rank is required")
    Competition competition;

    @NotNull(message = "Rank is required")
    Member member;

}