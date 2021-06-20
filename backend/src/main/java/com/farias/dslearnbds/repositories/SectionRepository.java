package com.farias.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farias.dslearnbds.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

}
