package com.youcode.aftas.core.dao.model.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Setter
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String location;
    private Double amount;


    @OneToMany(mappedBy = "competition")
    @ToString.Exclude
    private List<Hunting> huntingList;

    @OneToMany(mappedBy = "competition")
    @ToString.Exclude
//    @JoinTable(
//            name = "ranking",
//            joinColumns = @JoinColumn(name = "competition_id"),
//            inverseJoinColumns = {
//                    @JoinColumn(name = "member_id", insertable = false, updatable = false),
//                    @JoinColumn(name = "competition_id", insertable = false, updatable = false)
//            }
//    )
    private List<Ranking> rankingList;



}
