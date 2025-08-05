package com.workskill.backend_internhub.config;

import com.workskill.backend_internhub.repositories.ApplicantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataCleaner implements CommandLineRunner {
    private final ApplicantRepository   applicantRepository;

    public DataCleaner(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        applicantRepository.deleteAll();
        System.out.println("Applicants are cleaned up for fresh startup");
    }
}
