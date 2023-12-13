package com.youcode.aftas.core.utils.pipe.vm;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.youcode.aftas.core.dao.model.entity.Hunting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CompetitionVm {

    private UUID id;
    private String code;
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String location;
    private Double amount;
    private List<Hunting> huntingList;
    private List<RankingVm> rankingVmList;

}
