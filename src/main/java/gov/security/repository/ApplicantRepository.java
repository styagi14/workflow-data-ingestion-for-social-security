package gov.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.security.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> { 
    Optional<Applicant> findByNationalId(String nationalId);
}
