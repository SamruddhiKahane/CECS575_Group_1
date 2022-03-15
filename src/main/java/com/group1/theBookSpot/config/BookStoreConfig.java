package com.group1.theBookSpot.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.spring.web.plugins.Docket;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Configuration(value = "BookStoreConfig")
@Primary
public class BookStoreConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private Docket swaggerDocket;


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }




}
