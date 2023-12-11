package com.youcode.aftas.core.dao.model.dto;

import com.youcode.aftas.core.dao.model.entity.Competition;
import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * DTO for {@link Competition}
 */
@Value
public class CompetitionDto implements Serializable {
    @NotNull
    Date date;
    @NotNull
    Time startTime;
    @NotNull
    Time endTime;
    @NotNull
    @Min(1)
    @Max(1)
    @Positive
    Integer numberOfParticipants;
    @NotNull
    @NotEmpty
    @NotBlank
    String location;
    @NotNull
    @Min(50)
    @Positive
    Double amount;
}