package com.youcode.aftas.core.dao.model.dto;

import com.youcode.aftas.core.dao.model.entity.Fish;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Fish}
 */
@Value
public class FishDto implements Serializable {

    @NotBlank(message = "name is required")
    @Size(min = 4, max = 255, message = "Name should be between 4 and 255 characters")
    String name;

    @NotBlank(message = "averageWeight is required")
    @Size(max = 255, message = "averageWeight should not exceed 255 characters")
    @Positive(message = "Average weight should be a positive value")
    Double averageWeight;
}