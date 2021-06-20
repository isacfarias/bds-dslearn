package com.farias.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farias.dslearnbds.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
