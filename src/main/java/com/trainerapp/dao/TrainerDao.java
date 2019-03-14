package com.trainerapp.dao;

import com.trainerapp.model.Trainer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class TrainerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Trainer t) {
        entityManager.persist(t);
        return t.getId();
    }

    public Trainer update(Trainer t) {
        return entityManager.merge(t);
    }

    public void delete(Long id) {
        final Trainer t = entityManager.find(Trainer.class, id);
        if (t != null) {
            entityManager.remove(t);
        }
    }

    public Trainer findById(Long id) {
        return entityManager.find(Trainer.class, id);
    }

    public List<Trainer> findAll() {
        final Query query = entityManager.createQuery("SELECT t FROM Trainer t");

        return query.getResultList();
    }

//    public List<Student> findAllBornAfter(LocalDate ld) {
//        final Query query = entityManager.createNamedQuery(
//                "Student.findBornAfter"
//        );
//        query.setParameter("param1", ld);
//        return query.getResultList();
//    }

}

