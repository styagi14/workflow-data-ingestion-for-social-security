package gov.security.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.time.Instant;
import java.util.Map;

import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import gov.security.model.Applicant;
import gov.security.model.AttachmentMetadata;
import gov.security.repository.ApplicantRepository;
import gov.security.repository.AttachmentMetadataRepository;

@Service
@Transactional
public class ApplicantService {
    private final ApplicantRepository applicantRepo;
    private final AttachmentMetadataRepository attachmentRepo;
    private final FileStorageService fileStorageService;

    public ApplicantService(ApplicantRepository applicantRepo,
                            AttachmentMetadataRepository attachmentRepo,
                            FileStorageService fileStorageService) {
        this.applicantRepo = applicantRepo;
        this.attachmentRepo = attachmentRepo;
        this.fileStorageService = fileStorageService;
    }

    public Applicant createApplicant(Applicant applicant) {
        return applicantRepo.save(applicant);
    }

    public AttachmentMetadata saveAttachment(Long applicantId, MultipartFile file, String classification) {
        Applicant applicant = applicantRepo.findById(applicantId)
            .orElseThrow(() -> new IllegalArgumentException("Applicant not found: " + applicantId));
        try(InputStream is = file.getInputStream()){
            Map<String, Object> meta = Map.of("applicantId", applicantId, "classification", classification);
            String gridFsId = fileStorageService.storeFile(is, file.getOriginalFilename(), file.getContentType(), meta);
            AttachmentMetadata md = new AttachmentMetadata();
            md.setOriginalFilename(file.getOriginalFilename());
            md.setContentType(file.getContentType());
            md.setSize(file.getSize());
            md.setGridFsId(gridFsId);
            md.setClassification(classification);
            md.setUploadedAt(Instant.now());
            md.setApplicant(applicant);
            attachmentRepo.save(md);
            applicant.getAttachments().add(md);
            applicantRepo.save(applicant);
            return md;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public GridFsResource getFile(String gridFsId) {
        return fileStorageService.getFileResource(gridFsId);
    }

    // other helper methods
}

