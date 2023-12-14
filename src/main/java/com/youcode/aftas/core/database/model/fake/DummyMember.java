package com.youcode.aftas.core.database.model.fake;

import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;
import org.springframework.stereotype.Component;


import java.sql.Date;
import java.util.UUID;

@Component
public class DummyMember extends BaseFaker<Member>{

    @Override
    public Member  generate() {
        return Member.builder()
                .id(UUID.randomUUID())
                .familyName(faker.name().lastName())
                .accessionDate( new Date(faker.date().birthday().getTime()))
                .nationality(faker.country().name())
                .number(faker.number().numberBetween(0, 1000))
                .identityDocumentType(IdentityDocumentTypeEnum.values()[faker.number().numberBetween(0, IdentityDocumentTypeEnum.values().length)])
                .identityDocumentNumber(faker.idNumber().valid())
                .build();
    }


}
