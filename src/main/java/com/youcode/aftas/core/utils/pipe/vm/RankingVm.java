package com.youcode.aftas.core.utils.pipe.vm;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.youcode.aftas.core.dao.model.entity.Member;
import com.youcode.aftas.core.dao.model.entity.RankId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class RankingVm {
    private RankId id;

    private Integer rank;
    private Integer score;

    private Member member;

}
