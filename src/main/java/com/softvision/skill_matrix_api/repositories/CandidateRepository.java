package com.softvision.skill_matrix_api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.softvision.skill_matrix_api.model.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {
	
}
