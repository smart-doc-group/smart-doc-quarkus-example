package com.power.doc.kubernetes.quarkus.service;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author yu 2021/7/12.
 */
@ApplicationScoped
public class GreetingService {

    public String greeting(String name) {
        return "hello " + name;
    }
}
