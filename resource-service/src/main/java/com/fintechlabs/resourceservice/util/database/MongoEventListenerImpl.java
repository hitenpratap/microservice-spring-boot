package com.fintechlabs.resourceservice.util.database;

import com.fintechlabs.resourceservice.util.HelperMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class MongoEventListenerImpl extends AbstractMongoEventListener<Object> {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    HelperMethod helperMethod;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        LOG.info("Inside onAfterSave event of MongoDB for  ===>>>  " + source.getClass());
        Field field = ReflectionUtils.findField(source.getClass(), "uniqueId");
        if (field != null) {
            try {
                LOG.info("Inserting UniqueId record for class   ===>>>  " + source.getClass());
                field.set(source, helperMethod.fetchRandomUniqueStr());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
