package gov.security.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gov.security.model.Applicant;
import gov.security.model.ApplicantDto;
import gov.security.service.ApplicantService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createApplicant(
            @RequestPart(value = "data") ApplicantDto dto,
            @RequestPart(value = "files", required = false) List<MultipartFile> files,
            @RequestParam(value = "fileTypes", required = false) List<String> fileTypes) {

        // Convert DTO to entity
        Applicant applicant = dto.toEntity();
        Applicant saved = applicantService.createApplicant(applicant);

        if (files != null) {
            for (int i = 0; i < files.size(); i++) {
                MultipartFile file = files.get(i);
                String classification = (fileTypes != null && fileTypes.size() > i) ? fileTypes.get(i) : "UNKNOWN";
                applicantService.saveAttachment(saved.getId(), file, classification);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("applicantId", saved.getId()));
    }
}

