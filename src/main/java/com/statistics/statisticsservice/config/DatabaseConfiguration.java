package com.statistics.statisticsservice.config;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.statistics.statisticsservice.repository")
@Import(value = MongoAutoConfiguration.class)
public class DatabaseConfiguration {


    @Bean
    GridFsTemplate gridFsTemplate(MongoDatabaseFactory dbFactory, MongoConverter converter) throws Exception {
        return new GridFsTemplate(dbFactory, converter);
    }
}
