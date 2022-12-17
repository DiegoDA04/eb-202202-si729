package com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("behaviourMappingConfiguration")
public class MappingConfiguration {

    @Bean
    ScoreMapper scoreMapper(){ return new ScoreMapper();}
}
