package com.youcode.aftas.core.dao.model.fake;

import com.youcode.aftas.core.dao.model.entity.Hunting;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DummyHunting extends BaseFaker<Hunting> {
    @Override
    public Hunting generate() {
        return  Hunting.builder()
                .id(UUID.randomUUID())
                .numberOfFish(faker.number().randomDigit())
                .build();
    }
}
