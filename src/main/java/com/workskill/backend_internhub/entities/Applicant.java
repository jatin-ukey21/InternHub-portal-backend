package com.workskill.backend_internhub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "applicants")
public class Applicant {
    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private String role;
    private Date submittedAt;
}
