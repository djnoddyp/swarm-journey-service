package com.example.journeyservice.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@Transactional
public class JourneyRepository {

    @Inject
    EntityManager em;

    @Inject
    private Event<String> journeyEvent;

    private static final String FIND_ALL = "Journey.findAll";

    public List<Journey> findAll() {
        loadData();
        return em.createNamedQuery(FIND_ALL).getResultList();
    }

    void loadData() {
        em.persist(new Journey("home", "comber",
                LocalDate.of(2018, 4, 28), null));
        em.persist(new Journey("home", "home",
                LocalDate.of(2018, 4, 30), "big ride"));
        journeyEvent.fire("sample data loaded");
    }

}
