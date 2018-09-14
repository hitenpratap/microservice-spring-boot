package com.fintechlabs.authserver.service;

import com.fintechlabs.authserver.util.Bootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BootstrapService implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private Bootstrap bootstrap;

    @Override
    @Transactional()
    public void afterPropertiesSet() throws Exception {
        LOG.info("Bootstrapping data...");

        bootstrap.createRole();
        bootstrap.createEmployee();

        LOG.info("...Bootstrapping completed");
    }

}
