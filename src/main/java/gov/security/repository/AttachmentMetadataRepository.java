package gov.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.security.model.AttachmentMetadata;

public interface AttachmentMetadataRepository extends JpaRepository<AttachmentMetadata, Long> {
    List<AttachmentMetadata> findByApplicantId(Long applicantId);
}
