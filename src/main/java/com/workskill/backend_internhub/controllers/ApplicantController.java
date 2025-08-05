package com.workskill.backend_internhub.controllers;

import com.workskill.backend_internhub.dto.ApplicantDTO;
import com.workskill.backend_internhub.entities.Applicant;
import com.workskill.backend_internhub.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/registration")
    public ResponseEntity<Applicant> submitApplication(@RequestBody ApplicantDTO applicantDTO){
        return ResponseEntity.ok(applicantService.saveApplicant(applicantDTO));
    }

    @GetMapping("/applicants")
    public ResponseEntity<List<ApplicantDTO>> getAllApplicants(){
        return ResponseEntity.ok(applicantService.getAllApplicants());
    }
}
