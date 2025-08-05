package com.workskill.backend_internhub.repositories;

import com.workskill.backend_internhub.entities.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicantRepository extends MongoRepository<Applicant,String> {
}
