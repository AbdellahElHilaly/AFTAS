package com.youcode.aftas.core.dao.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer code;
    private String description;
    private Integer points;

    @OneToMany(mappedBy = "level")
    @ToString.Exclude
    private List<Fish> fishList;

}
