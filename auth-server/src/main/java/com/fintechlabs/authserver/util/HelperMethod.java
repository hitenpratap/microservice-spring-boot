package com.fintechlabs.authserver.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HelperMethod {

    public String fetchRandomUniqueStr() {
        return UUID.randomUUID().toString();
    }

}
