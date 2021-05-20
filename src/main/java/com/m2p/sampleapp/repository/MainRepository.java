package com.m2p.sampleapp.repository;

import com.m2p.sampleapp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Request, Integer>, CalcRepository {

}
