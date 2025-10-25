package gov.security.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class ApplicantDto {
    @NotBlank private String firstName;
    @NotBlank private String lastName;
    private String nationalId;
    private String email;
    private String phone;
    private String dob; // ISO date string
    private Double monthlyIncome;
    private Integer yearsOfExperience;
    private Integer familySize;
    private Double totalAssets;
    private Double totalLiabilities;
    private Integer age;
    private boolean eligibilityLabel;

    public Applicant toEntity() {
        Applicant a = new Applicant();
        a.setFirstName(firstName);
        a.setLastName(lastName);
        a.setNationalId(nationalId);
        if (dob != null) a.setDob(LocalDate.parse(dob));
        a.setEmail(email);
        a.setPhone(phone);
        a.setMonthlyIncome(monthlyIncome);
        a.setYearsOfExperience(yearsOfExperience);
        a.setFamilySize(familySize);
        a.setTotalAssets(totalAssets);
        a.setTotalLiabilities(totalLiabilities);
        a.setAge(age);
        a.setEligibilityLabel(eligibilityLabel); 
        return a;
    }
}

