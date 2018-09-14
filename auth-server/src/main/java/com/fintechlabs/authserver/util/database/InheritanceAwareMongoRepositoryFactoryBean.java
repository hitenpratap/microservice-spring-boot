package com.fintechlabs.authserver.util.database;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import java.io.Serializable;

public class InheritanceAwareMongoRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends MongoRepositoryFactoryBean<T, S, ID> {

    public InheritanceAwareMongoRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
        return new InheritanceAwareMongoRepositoryFactory(operations);
    }

}
