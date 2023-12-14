package com.youcode.aftas.core.utils.Config;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.entity.Level;
import com.youcode.aftas.core.database.model.dto.response.CompetitionResponse;
import com.youcode.aftas.core.database.model.dto.response.FishResponse;
import com.youcode.aftas.core.database.model.dto.response.LevelResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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


            return modelMapper;
        }
    }
}
