package com.farias.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farias.dslearnbds.entities.Deliver;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long> {

}
