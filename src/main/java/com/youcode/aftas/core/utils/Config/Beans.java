package com.youcode.aftas.core.utils.Config;


import com.youcode.aftas.core.dao.model.entity.Competition;
import com.youcode.aftas.core.utils.pipe.vm.CompetitionVm;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Configuration
    public class ModelMapperConfig {

        @Bean
        public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();

            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            modelMapper.typeMap(Competition.class, CompetitionVm.class)
                    .addMapping(src -> src.getRankingList(), CompetitionVm::setRankingVmList);

            return modelMapper;
        }
    }
}