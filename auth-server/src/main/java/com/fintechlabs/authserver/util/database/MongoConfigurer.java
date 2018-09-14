package com.fintechlabs.authserver.util.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(repositoryBaseClass = InheritanceAwareSimpleMongoRepository.class,
        repositoryFactoryBeanClass = InheritanceAwareMongoRepositoryFactoryBean.class,
        basePackages = {"com.fintechlabs.authserver.repository"})
public class MongoConfigurer {
}
