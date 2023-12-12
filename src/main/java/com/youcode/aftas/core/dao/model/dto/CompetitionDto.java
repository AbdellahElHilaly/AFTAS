package com.youcode.aftas.core.dao.model.dto;


import com.youcode.aftas.core.dao.model.entity.Competition;
import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 * DTO for {@link Competition}
 */
@Value
public class CompetitionDto implements Serializable {
    @NotBlank(message = "Code is required")
    @Size(max = 255, message = "Code should not exceed 255 characters")
    String code;

    @NotNull(message = "Date is required")
    @Future(message = "Date should be in the future")
    Date date;

    @NotNull(message = "Start time is required")
    @FutureOrPresent(message = "Start time should be in the present or future")
    Time startTime;

    @NotNull(message = "End time is required")
    @FutureOrPresent(message = "End time should be in the present or future")
    Time endTime;

    @NotNull(message = "Number of participants is required")
    @Min(value = 1, message = "Number of participants should be at least 1")
    Integer numberOfParticipants;

    @NotBlank(message = "Location is required")
    @Size(max = 255, message = "Location should not exceed 255 characters")
    String location;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount should be positive")
    Double amount;



}
