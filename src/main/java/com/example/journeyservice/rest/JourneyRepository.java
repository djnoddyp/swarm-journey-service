package com.example.journeyservice.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class JourneyRepository {

    @PersistenceContext
    EntityManager em;

    public void startup() {
        em.persist(new Journey("home", "comber",
                LocalDate.of(2018, 4, 28), Optional.of("")));
        em.persist(new Journey("home", "home",
                LocalDate.of(2018, 4, 30), Optional.of("big ride")));
    }

    public List<Journey> findAll() {
        startup();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Journey> criteria = builder.createQuery(Journey.class);
        Root<Journey> root = criteria.from(Journey.class);
        criteria.select(root);
        return em.createQuery(criteria).getResultList();
    }

}
