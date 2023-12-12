package com.youcode.aftas.core.dao.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.sql.Time;

/**
 * DTO for {@link com.youcode.aftas.core.dao.model.entity.Hunting}
 */
@Value
@NoArgsConstructor(force = true)
public class HuntingDto implements Serializable {

    @NotNull(message = "Number of fish is required")
    @Positive(message = "Number of fish should be a positive value")
    Integer numberOfFish;




}

