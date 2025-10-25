package gov.security.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "attachment")
public class AttachmentMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFilename;
    private String contentType;
    private Long size;

    // store GridFS ObjectId as string
    private String gridFsId;

    private String classification; // e.g., BANK_STATEMENT, EMIRATES_ID, RESUME, EXCEL_ASSET, CREDIT_REPORT

    private Instant uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getGridFsId() {
		return gridFsId;
	}

	public void setGridFsId(String gridFsId) {
		this.gridFsId = gridFsId;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Instant getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(Instant uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
    
    
}
