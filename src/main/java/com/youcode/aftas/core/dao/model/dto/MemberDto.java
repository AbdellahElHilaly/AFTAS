package com.youcode.aftas.core.dao.model.dto;

import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;
import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link com.youcode.aftas.core.dao.model.entity.Member}
 */
@Value
public class MemberDto implements Serializable {
    @NotNull(message = "The number is required!")
    @Min(value = 1, message = "The minimum value for number is 1")
    @Positive(message = "The number should be positive")
    Integer number;

    @NotBlank(message = "Family name is required")
    @Size(min = 4, max = 255, message = "Family Name should be between 4 and 255 characters")
    String familyName;

    @NotNull(message = "Accession date is required")
    Date accessionDate;

    @NotBlank(message = "Nationality is required")
    @Size(max = 255, message = "Nationality should not exceed 255 characters")
    String nationality;

    @NotNull(message = "Identity document type is required")
    IdentityDocumentTypeEnum identityDocumentType;

    @NotBlank(message = "Identity document number is required")
    @Size(max = 255, message = "Identity document number should not exceed 255 characters")
    String identityDocumentNumber;
}
