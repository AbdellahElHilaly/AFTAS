package com.youcode.aftas.core.dao.model.fake;

import com.youcode.aftas.core.dao.model.entity.Fish;
import org.springframework.stereotype.Component;

@Component
public class DummyFish extends BaseFaker<Fish> {

    @Override
    public Fish generate() {
        return Fish.builder()
                .name(faker.lorem().characters(5))
                .averageWeight(faker.number().randomDouble(2, 0, 1000))
                .build();
    }
}
