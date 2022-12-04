package com.example.assignment3;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperBean {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
