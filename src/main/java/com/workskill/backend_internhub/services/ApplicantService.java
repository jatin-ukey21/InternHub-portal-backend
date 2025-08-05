package com.workskill.backend_internhub.services;

import com.workskill.backend_internhub.dto.ApplicantDTO;
import com.workskill.backend_internhub.entities.Applicant;
import com.workskill.backend_internhub.repositories.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public Applicant saveApplicant(ApplicantDTO dto){
        Applicant applicant = new Applicant();
        applicant.setName(dto.getName());
        applicant.setEmail(dto.getEmail());
        applicant.setPhone(dto.getPhone());
        applicant.setRole(dto.getRole());
        applicant.setSubmittedAt(new Date());

        return applicantRepository.save(applicant);
    }

    public List<ApplicantDTO> getAllApplicants(){
        List<ApplicantDTO> applicants = applicantRepository.findAll()
                .stream()
                .map(applicant -> new ApplicantDTO(
                        applicant.getName(),
                        applicant.getEmail(),
                        applicant.getPhone(),
                        applicant.getRole(),
                        applicant.getSubmittedAt()
                ))
                .collect(Collectors.toList());
        return applicants;
    }
}
