package com.youcode.aftas.core.dao.model.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.youcode.aftas.core.utils.pipe.Real;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Competition {
    @Id
    private UUID id;

    private String Code;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Integer numberOfParticipants;
    private String location;
    private Double amount;

    @OneToMany
    @ToString.Exclude
    private List<Hunting> huntingList;

    @OneToMany(mappedBy = "competition")
    @ToString.Exclude
    private List<Ranking> rankingList;

}
