package com.youcode.aftas.core.dao.model.fake;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.youcode.aftas.core.dao.model.entity.RankId;
import com.youcode.aftas.core.dao.model.entity.Ranking;
import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;
import org.springframework.stereotype.Component;


import java.sql.Date;
import java.util.UUID;

@Component
public class DummyRanking extends BaseFaker<Ranking>{

    @Override
    public Ranking  generate() {
        return Ranking.builder()
                .id(RankId.builder()
                        .memberId(UUID.randomUUID())
                        .competitionId(UUID.randomUUID())
                        .build())
                .rank(faker.number().numberBetween(0, 1000))
                .score(faker.number().numberBetween(0, 1000))
                .build();
    }


}
