package com.workskill.backend_internhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDTO {
    private String name;
    private String email;
    private String phone;
    private String role;
    private Date submittedAt;
}
