package gov.security.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String nationalId; // Emirates ID
    private LocalDate dob;
    private String email;
    private String phone;

    private Double monthlyIncome;
    private Double householdIncome;
    
    private Integer yearsOfExperience;
    private Integer familySize;
    private Double totalAssets;
    private Double totalLiabilities;
    private Integer age;
    private boolean eligibilityLabel;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttachmentMetadata> attachments = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public Double getHouseholdIncome() {
		return householdIncome;
	}

	public void setHouseholdIncome(Double householdIncome) {
		this.householdIncome = householdIncome;
	}


	public List<AttachmentMetadata> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<AttachmentMetadata> attachments) {
		this.attachments = attachments;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Integer getFamilySize() {
		return familySize;
	}

	public void setFamilySize(Integer familySize) {
		this.familySize = familySize;
	}

	public Double getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(Double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public Double getTotalLiabilities() {
		return totalLiabilities;
	}

	public void setTotalLiabilities(Double totalLiabilities) {
		this.totalLiabilities = totalLiabilities;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isEligibilityLabel() {
		return eligibilityLabel;
	}

	public void setEligibilityLabel(boolean eligibilityLabel) {
		this.eligibilityLabel = eligibilityLabel;
	}
	
	
    
    
}
