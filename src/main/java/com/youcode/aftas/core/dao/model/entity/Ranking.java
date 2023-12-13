package com.youcode.aftas.core.dao.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"member_id", "competition_id"})})
public class Ranking {

    @EmbeddedId
    private RankId id;

    private Integer rank;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @MapsId("memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    @MapsId("competitionId")
    private Competition competition;

}
