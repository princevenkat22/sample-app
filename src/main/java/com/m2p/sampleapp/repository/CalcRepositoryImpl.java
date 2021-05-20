package com.m2p.sampleapp.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CalcRepositoryImpl implements CalcRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Double calcResult(Double inp1, char operator, Double inp2) {
        String sql = "SELECT ".concat(":inp1").concat(" ").concat(String.valueOf(operator)).concat(" ")
                .concat(":inp2");
        return (Double) entityManager
                .createNativeQuery(sql)
                .setParameter("inp1", inp1)
                .setParameter("inp2", inp2)
                .getSingleResult();
    }
}
