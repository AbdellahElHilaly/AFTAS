package com.youcode.aftas.core.utils.Config;

import com.youcode.aftas.core.database.model.dto.request.HuntingRequest;
import com.youcode.aftas.core.database.model.entity.*;
import com.youcode.aftas.core.database.model.dto.response.CompetitionResponse;
import com.youcode.aftas.core.database.model.dto.response.FishResponse;
import com.youcode.aftas.core.database.model.dto.response.LevelResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class Beans {

    @Configuration
    public static class ModelMapperConfig {

        @Bean
        public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();

            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            // Competition to CompetitionResponse
            modelMapper.typeMap(Competition.class, CompetitionResponse.class)
                    .addMapping(Competition::getRankingList, CompetitionResponse::setRankingList);

            // Level to LevelResponse
            modelMapper.typeMap(Level.class, LevelResponse.class)
                    .addMapping(Level::getFishList, LevelResponse::setFishList);

            //Fish to FishResponse
            modelMapper.typeMap(Fish.class, FishResponse.class)
                    .addMapping(Fish::getHuntingList, FishResponse::setHuntingList);

            //member to memberResponse
            modelMapper.typeMap(Fish.class, FishResponse.class)
                    .addMapping(Fish::getHuntingList, FishResponse::setHuntingList);

            // HuntingRequest to Hunting
            modelMapper.createTypeMap(HuntingRequest.class, Hunting.class)
                    .addMapping(HuntingRequest::getNumberOfFish, Hunting::setNumberOfFish)
                    .addMapping(HuntingRequest::getFishId, (destination, value) -> destination.getFish().setId((UUID) value))
                    .addMapping(HuntingRequest::getCompetitionId, (destination, value) -> destination.getCompetition().setId((UUID) value))
                    .addMapping(HuntingRequest::getMemberId, (destination, value) -> destination.getMember().setId((UUID) value));


            return modelMapper;
        }
    }
}
