package com.farias.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farias.dslearnbds.entities.Enrollment;
import com.farias.dslearnbds.entities.pk.EnrollmentId;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {

}
