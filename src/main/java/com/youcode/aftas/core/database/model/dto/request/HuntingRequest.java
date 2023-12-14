package com.youcode.aftas.core.database.model.dto.request;

import com.youcode.aftas.core.database.model.entity.Hunting;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Hunting}
 */
@Value
@NoArgsConstructor(force = true)
public class HuntingRequest implements Serializable {

    @NotNull(message = "Number of fish is required")
    @Positive(message = "Number of fish should be a positive value")
    Integer numberOfFish;




}

