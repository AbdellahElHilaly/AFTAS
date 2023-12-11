package com.youcode.aftas.core.dao.model.dto;

import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link com.youcode.aftas.core.dao.model.entity.Member}
 */
@Value
public class MemberDto implements Serializable {
    @NotNull(message = "the number required !")
    @Min(message = "the min value is : 1", value = 1)
    @Positive(message = "the number should be positove")
    Integer number;
    String familyName;
    Date accessionDate;
    String nationality;
    IdentityDocumentTypeEnum identityDocumentType;
    String identityDocumentNumber;
}