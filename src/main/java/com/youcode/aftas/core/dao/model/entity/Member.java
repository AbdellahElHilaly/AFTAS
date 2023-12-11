package com.youcode.aftas.core.dao.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Member {
    @Id
    private UUID id;

    private Integer number;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentTypeEnum identityDocumentType;
    private String identityDocumentNumber;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    private List<Ranking> rankingList;

}
