package com.project.freshman.applicant.repository;

import com.project.freshman.applicant.model.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Optional<Applicant> findByApplicantEmail(String email);
}
