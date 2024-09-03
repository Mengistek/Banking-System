package com.bankaccount.cs425bank.Configeration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper (){
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper;
    }
}
