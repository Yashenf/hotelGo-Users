package com.travelgo.user.service;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravelerIdGenerator {

    @Bean
    public Serializable generate() throws HibernateException {
        String prefix = "TRVlGO@";
        UUID uuid = UUID.randomUUID();
        String id = prefix + uuid.toString();
        return id;
    }
}


