package com.example.journeyservice.rest;


import org.jboss.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
public class JourneyObserver implements Serializable {

    @Inject
    Logger logger;

    private void observeJourney(@Observes String message) {
        logger.info("info " + message);
        logger.debug("debug " + message);
    }

}
