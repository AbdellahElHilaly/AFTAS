package com.youcode.aftas.core.dao.model.fake;

import com.youcode.aftas.core.dao.model.entity.Level;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DummyLevel extends BaseFaker<Level> {

    @Override
    public Level generate() {
        return Level.builder()
                .id(UUID.randomUUID())
                .code(Integer.valueOf(faker.lorem().characters(5)))
                .description(faker.lorem().characters(100))
                .points(faker.number().numberBetween(0, 1000))
                .build();
    }
}



