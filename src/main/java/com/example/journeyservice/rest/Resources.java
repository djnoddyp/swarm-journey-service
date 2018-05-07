package com.example.journeyservice.rest;

import org.jboss.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@SessionScoped
public class Resources implements Serializable {

    @Produces
    @PersistenceContext
    private EntityManager em;

    @Produces
    private Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

}
