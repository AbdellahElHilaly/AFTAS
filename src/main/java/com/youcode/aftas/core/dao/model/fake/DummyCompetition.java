package com.youcode.aftas.core.dao.model.fake;

import com.youcode.aftas.core.dao.model.entity.Competition;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Component
public class DummyCompetition extends BaseFaker<Competition> {

    @Override
    public Competition generate() {
        return Competition.builder()
                .id(UUID.randomUUID())
                .code(faker.lorem().characters(5))
                .date(new Date(faker.date().birthday().getTime()))
                .startTime(new Time(faker.date().birthday().getTime()))
                .endTime(new Time(faker.date().birthday().getTime()))
                .numberOfParticipants(faker.number().numberBetween(0, 1000))
                .location(faker.address().fullAddress())
                .amount(faker.number().randomDouble(2, 0, 1000))
                .build();


    }
}



