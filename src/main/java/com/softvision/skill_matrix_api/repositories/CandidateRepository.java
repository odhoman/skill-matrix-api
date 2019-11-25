package com.softvision.skill_matrix_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softvision.skill_matrix_api.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
}
